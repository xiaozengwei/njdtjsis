function subforms() {
    var part_form = $("#part-form", $.CurrentNavtab); //form
    var _process_line_form = $("#process_line_form", $.CurrentNavtab);

    $(".process-user-names", _process_line_form).each(function() {
        var usr_names = $(this).val();
        if (usr_names.length > 0) {
            usr_names = encodeURI(usr_names);
            $(this).val(usr_names);
        }
    });
    var _redirectUrl = $("#redirectUrl", $.CurrentNavtab).val();
    var basePath = $("#global-base-path", $.CurrentNavtab).val();
    $("#btn-global-form", $.CurrentNavtab).hide();
    $("#btn-global-grey", $.CurrentNavtab).show();
    $.ajax({
        type: _process_line_form.attr("method") || 'POST',
        url: _process_line_form.attr("action"),
        data: _process_line_form.serializeArray(),
        dataType: "json",
        cache: false,
        success: function(json) {
            var processInstId = json.processInstId || ""; //流程实例ID
            var selectedUserIds = json.selectedUserIds || ""; //已选择用户登录名
            var selectedUserNames = json.selectedUserNames || "" //已选择用户名	
            var currentActId = json.currentActId || ""; //当前节点ID
            var currentActName = json.currentActName || ""; //当前节点名称
            var userActionType = json.userActionType || ""; //用户选择动作  0=XXX默认提交给selectedUserNames  1=XXX新增任务给selectedUserNames
            var processDefId = json.processDefId || ""; //流程模版ID
            var processKey = json.processKey || ""; //流程KEY
            var businessKey = json.businessKey || ""; //流程表单键
            var blfs = json.blfs; //办理方式1,2,3，4
            $("#ptid", part_form).val(processKey);
            $("#piid", part_form).val(processInstId);
            $("#atid", part_form).val(currentActId);
            $("#selectedUserIds", part_form).val(selectedUserIds);
            $("#selectedUserNames", part_form).val(selectedUserNames);
            $("#currentActName", part_form).val(currentActName);
            $("#userActionType", part_form).val(userActionType);
            $("#processDefineId", part_form).val(processDefId);
           
            $("#blfs", part_form).val(blfs); //将流程表单里的处理方式至发文表单
            //2.提交表单
            var msg_type = 'ok';
            $.ajax({
                type: part_form.attr("method") || 'POST',
                url: part_form.attr("action"),
                data: part_form.serializeArray(),
                dataType: "json",
                cache: false,
                success: function(json) {
                    if (json.statusCode == BJUI.statusCode.ok) {

                        part_form.navtab('closeCurrentTab');

                        part_form.navtab({
                            id: '_redirectUrl',
                            url: basePath + _redirectUrl,
                            title: '待办事宜',
                            fresh: 'true'
                        });

                    } else {
                        msg_type = 'info';
                    }
                    part_form.alertmsg(msg_type, json.message);

                }
            });

        }

    });
}
//校验表单
function validateSForm() {
    var part_form = $("#part-form", $.CurrentNavtab); //form
    var res_flag;
    part_form.isValid(function(v) {
        res_flag = (v ? true: false);
    });
    return res_flag;
}
/**
 * 检查是否选择下一步参与者，若选择、继续，否则提示，不提交表单
 */
function checkProcessUser() {
    var part_form = $("#part-form", $.CurrentNavtab); //form
    var _process_line_form = $("#process_line_form", $.CurrentNavtab);

    var _flow_radio_checked = $(".flow-radio:checked", _process_line_form);
    var _flow_id = _flow_radio_checked.attr("flow-name") || "";
    var _flow_user_selected = $("input[name='" + _flow_id + ".pid']", _process_line_form);
    if (_flow_user_selected.length > 0) {
        if (_flow_user_selected.val().length < 1) {
            part_form.alertmsg("info", "请选择下一步参与者");
            return false;
        }
    }
    return true;

}

$(function() {
    $("#btn-global-form", $.CurrentNavtab).unbind("click").on("click",
    function(e) {
    	 var basePath = $("#global-base-path", $.CurrentNavtab).val();
        var part_form = $("#part-form", $.CurrentNavtab); //form
        var _process_line_form = $("#process_line_form", $.CurrentNavtab);

        var form_operation_name = $("#operationName", part_form).val() || ""; //操作名称
        //双击选择意见
        part_form.find(".dbclickLookup").unbind("dblclick").on("dblclick",
        function() {
            var $this = $(this);
            if (!$this.attr("readonly")) {
                var txtName = $this.attr("name");
                $this.dialog({
                    id: 'advice_dialog',
                    url: basePath + '/dic/advice-list.do?column=' + txtName,
                    title: '请选择',
                    width: 770,
                    height: 800
                });
            }

        });

        //1.提交流程
        var form_fw_title = $("#form-title", part_form);
        var form_fw_title_val = form_fw_title.val() || "";
        $("#process_line_form_fwtitle", _process_line_form).val(form_fw_title_val); //将发文表单里的标题传值至流程表单里
        if (form_operation_name == 'read-handle') { //办文单:阅办单3处意见必须填写至少一处
            var v_advice = "";
            $(".required-advice", part_form).each(function() {
                v_advice += $(this).val();
            });
            if (v_advice.length < 1) {
                part_form.alertmsg("info", "请填写意见");
                return;
            }

            if (checkProcessUser()) {
                subforms();
            }
        } else if (form_operation_name == 'shouwen-update') { //收文登记-update
            var file_attIds = $("#form_attachmentId", part_form).val() || "";
            if (file_attIds.length < 1) {
                $(this).alertmsg("confirm", "未上传附件请是否继续提交", {
                    okCall: function() {
                        checkProcessUser();
                    }
                });
            } else {
                checkProcessUser();
            }
        } else if (form_operation_name == 'shouwen-form') { //收文登记
            var v_advice_list = $("#div-advice-list", part_form);
            var v_advices = "";
            $(".div-advice-generated", v_advice_list).each(function() {
                var leader_name = $(this).find("input[name='leader-name']").val() || "";
                var leader_advice = $(this).find("input[name='leader-advice']").val() || "";
                if (leader_name.length > 0 && leader_advice.length > 0) {
                    v_advices += leader_name + " 批示意见：" + leader_advice + "</br>";
                }
            });
            $("#outLeaderInstro", part_form).val(v_advices);

            var file_attIds = $("#form_attachmentId", part_form).val() || "";
            if (file_attIds.length < 1) {
                $(this).alertmsg("confirm", "未上传附件请是否继续提交", {
                    okCall: function() {
                        var check_flag = checkProcessUser(); //检验下一步人员是否填写完整
                        if (check_flag) {
                            var validate_flag = validateSForm(); //表单验证
                            if (validate_flag) {
                                subforms();
                            }

                        }

                    }
                });
            } else {
                var check_flag = checkProcessUser();
                if (check_flag) {
                    var validate_flag = validateSForm();
                    if (validate_flag) {
                        subforms();
                    } else {
                        part_form.trigger('validate');
                        return;
                    }
                }
            }
        } else if (form_operation_name == 'fawen-form') { //发文
            var v_advice = "";
            $(".required-advice", part_form).each(function() {
                v_advice += $(this).val();
            });
            if (v_advice.length < 1) {
                part_form.alertmsg("info", "请填写意见");
                return;
            }
            if ($("#mianWordId", part_form).val().length < 1) {
                part_form.alertmsg("info", "请编辑正文");
                return;
            }

            var check_flag = checkProcessUser();
            if (check_flag) {
                var validate_flag = validateSForm();
                if (validate_flag) {
                    subforms();

                }
            }
        } else if (form_operation_name == 'fawen-update') { //发文update
            var v_advice = "";
            $(".required-advice", part_form).each(function() {
                v_advice += $(this).val();
            });
            if (v_advice.length < 1) {
                part_form.alertmsg("info", "请填写意见");
                return;
            }
            if ($("#mianWordId", part_form).val().length < 1) {
                part_form.alertmsg("info", "请编辑正文");
                return;
            }

            var check_flag = checkProcessUser();
            if (check_flag) {
                var validate_flag = validateSForm();
                if (validate_flag) {
                    subforms();

                }
            }
        }else if(form_operation_name == 'normal-form'){
        	 var check_flag = checkProcessUser();
             if (check_flag) {
                 var validate_flag = validateSForm();
                 if (validate_flag) {
                     subforms();

                 }
             }
        } else {
            subforms();
        }

    });
    //取消按钮
    $("#btn-global-close").unbind("click").on("click",
    function() {
        var part_form = $("#part-form", $.CurrentNavtab); //form
        part_form.navtab('closeCurrentTab');
    });
    
    
    //已阅按钮
    $("#part-form", $.CurrentNavtab).unbind("click").on("click", ".btn-global-check",
    function() {
    	
        var part_form = $("#part-form", $.CurrentNavtab);
        var input_target = $(this).data("target");
       
        $("#"+input_target,part_form).val("已阅");
        var _process_line_form = $("#process_line_form", $.CurrentNavtab);
        var flow_radio = $(".flow-radio:checked",_process_line_form);
        //在已阅状态下，点选新增任务选择人员会被重置，默认选择“完成任务选项”
        if(!flow_radio.hasClass("rd-finished")){
        	var _flow_id = flow_radio.attr("flow-name") || "";
            var _flow_user_selected = $("input[name='" + _flow_id + ".pid']", _process_line_form);
            _flow_user_selected.val("");
            flow_radio.removeAttr("checked");
        	 $(".flow-radio",_process_line_form).each(function(){
        		if($(this).hasClass("rd-finished")){
        			$(this).attr("checked","checked");
        		} 
        	 });
        }
        subforms();
    });
    //文件关联-删除按钮
    $("#btn-file-relation-delete",$.CurrentNavtab).unbind("click").on("click",function(){
    	var btn_select = $(this);
		var chk_file_id = $.CurrentNavtab.find("input[name='chk-file-relation']:checked");
		if(chk_file_id.length < 1){
			btn_select.alertmsg("info", "请选择要删除的关联文件");
			return false;
		}
		var file_ids = "";
		chk_file_id.each(function(){
			file_ids+= $(this).val() +",";
		});
		if(file_ids.length >0 && file_ids.indexOf(",") != -1){
			file_ids = file_ids.substring(0,file_ids.length -1);
		}
		var list_table_body = $.CurrentNavtab.find("#file-relation-table>tbody");
		btn_select.alertmsg("confirm", btn_select.data("warn"), {
            okCall: function() {
				$.ajax({
					url:btn_select.data("url"),
					type:'post',
					data:{
						delids:file_ids
					},
					dataType:'json',
					success:function(json){
						if(json.statusCode == BJUI.statusCode.ok){
							var part_form = $("#part-form", $.CurrentNavtab);
							var ids = json.ids;
							$.each(ids,function(i,id){
								list_table_body.find("[name='"+id+"']").remove();
								var doc_relation_ids  = part_form.find("#doc_relation_ids");
								
								var rids = doc_relation_ids.val();
								var ridArr = rids.split(",");
								if(ridArr.contains(id)){
									var index_ = getIndexOfStrArr(ridArr,id);
									ridArr.remove(index_);
								}
								if(ridArr.length > 0){
									rids = ridArr.join(",");
								}else{
									rids ="0";
								}
								doc_relation_ids.val(rids);
							});
							btn_select.alertmsg("ok", "删除成功");
						}
					}
				});
            }});
	});
    //收转发按钮
    $("#btn-global-sw2fw",$.CurrentNavtab).unbind("click").on("click",function(){
    	var btn_select = $(this);
    	 var part_form = $("#part-form", $.CurrentNavtab);
    	 var swId =part_form.find("#swId").val()||"";
    	 var docType  = part_form.find("#doc-Type").val()||"sw";
    	// var sxId = docType == 'sw' ? 'key-fw':'key-'
    	btn_select.alertmsg("confirm", btn_select.data("warn"), {
            okCall: function() {
            	btn_select.navtab({id:$.CurrentNavtab.id, url:'../process/go-process.do?sxId=key-fw&swId='+swId+"&docType="+docType, title:'新增发文'});
            }
    		
    	});
            
    });
    //増阅按钮
    $("#btn-global-send-read",$.CurrentNavtab).unbind("click").on("click",function(){
    	var btn_select = $(this);
   	 	var part_form = $("#part-form", $.CurrentNavtab);
   	 	var docType  = part_form.find("#doc-Type").val()||"sw";
    	btn_select.dialog({id:'dialog-content-send-read', url:$(this).data("url") +"&docType="+docType, title:$(this).data("title"),width:$(this).data("width"),height:$(this).data("height"),mask:true});

    	
    /*	var part_form = $("#part-form", $.CurrentNavtab);
    	var swId =part_form.find("#swId").val()||"";
    	btn_select.alertmsg("confirm", btn_select.data("warn"), {
    		okCall: function() {
    			btn_select.navtab({id:$.CurrentNavtab.id, url:'../process/go-process.do?sxId=key-fw&swId='+swId, title:'新增发文'});
    		}
    	
    	});*/
    	
    });

});