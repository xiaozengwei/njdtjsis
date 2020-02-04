currentActiveId = "";
$(function(){
	//var basePath = $("#global-base-path", $.CurrentNavtab).val();
	$("#templet-page-container",$.CurrentNavtab).ajaxStop(function(){
		var isLoad = $(this).find("#isLoad");
		if(isLoad.val() =='1'){
			return ;
		}
		isLoad.val("1");
		//加载js文件
		var s = document.createElement('script');  
	     s.type = 'text/javascript';  
	     s.async = false;  
	     s.src = _BASE_PATH+'gx/js/operator.js';  
	     var x = document.getElementsByTagName('script')[0];  
	     x.parentNode.insertBefore(s, x); 
	     
	     
		var _process_line_form = $("#process_line_form", $.CurrentNavtab);
	    var part_form = $("#part-form", $.CurrentNavtab); //form
	    var div_opeartor = $("#opeartor", $.CurrentNavtab); //form
	    var processInstanceId = $("#processInstanceId", _process_line_form).val()||"";
	    var currentActId = $("#actid", _process_line_form).val()||"usertask-1";
	    var blfs = $("#blfs", _process_line_form).val() || "";
	    var businessKey = $("#businessKey", _process_line_form).val() || "";
	    var btn_global_check = $(".btn-global-check", part_form);//已阅按钮
	    var fw_actid = $("#atid", part_form);//发文表单元素
	   
	    var tpedit = $("#btn-dispatch-tp-edit", part_form); //排版定稿
	    var tpshow = $("#btn-dispatch-tp-show", part_form); //查看终稿
	    var sxpzid = $("#sxpzid", part_form).val() || ""; //sxpzid
	    var isPrivillege = $("#isPrivillege", part_form).val() || ""; //sxpzid
	    var btn_sw2fw = $("#btn-global-sw2fw", div_opeartor); //收转发
	    var btn_send_read = $("#btn-global-send-read", div_opeartor); //阅知
	   // btn_global_check.hide();
	    if( (businessKey == 'key-sw' ||businessKey == 'key-ww')&& blfs == '2' ){
	        btn_global_check.show();
	    }
	   // debugger;
	   // if(fw_businessKey)	    fw_businessKey.val(businessKey);
	    currentActiveId =currentActId;
	    if (currentActId == 'usertask10') { //排版定稿状态，仅显示排版定稿
	        if (tpedit.length > 0) {
	            tpedit.show();
	        }
	        tpshow.hide();
	        $(".word-new", part_form).each(function() { //隐藏编辑正文、预览模版按钮
	            $(this).hide();
	        });

	    } else if (currentActId == 'usertask3') { //查看终稿
	        if (tpshow.length > 0) {
	        	tpshow.show();
	        }

	        $(".word-new", part_form).each(function() { //隐藏编辑正文、预览模版按钮
	            $(this).hide();
	        });
	        tpedit.hide();

	    } else { //默认新增
	        if (tpedit.length > 0) {
	            tpedit.hide();
	        }
	        tpshow.hide();
	        $(".word-new", part_form).each(function() { //show编辑正文、预览模版按钮
	            $(this).show();
	        });
	       
	    }
	   // debugger;
	    if ((businessKey == 'key-sw'||businessKey == 'key-ww') && currentActId.length > 0 ) {//发文情况下,和收文情况下新增。无收转发按钮
	    	btn_sw2fw.show();
	    	btn_send_read.show();
	    }
	   
	    if(businessKey =='key-fw' && currentActId.length < 1){//收文情况下
	    	 var file_relation= $("#file-relation",$.CurrentNavtab);
		    var swBeanRowid =file_relation .find("#swBean-rowId").val()||"";
		    var swBeanTitle = file_relation.find("#swBean-title").val()||"";
		    var doc_relation_id = part_form.find("#doc_relation_ids");
		    var rids = doc_relation_id.val()||"";
		    if(swBeanRowid.length > 0){
			    if(rids.length < 1){//初始化的情况下
			    	doc_relation_id.val(swBeanRowid);//收转发情况下
				  	part_form.find("#form-title").val(swBeanTitle);//收转发情况下
			    }
			 }
	    }
   	 	//var swId =part_form.find("#swId").val()||"";
   	 	var sendReadFlag =part_form.find("#also").val()||"";//阅知
   	 	if(sendReadFlag.length > 0){
   	 		btn_send_read.show();
   	 	}
   	 	
   	 	//页面表单元素权限控制
   	 	var _url=_BASE_PATH+"form-privillege/list.do";
   	 	var _data= {
   	 		ptId:sxpzid,
   	 		atId:currentActId,
   	 		businessKey:businessKey
   	 	};
   	 	if(isPrivillege=='1'){
   	 		
	   	 	$.ajax({
	   	 		url:_url,
	   	 		data:_data,
	   	 		type:'post',
	   	 		success:function(json){
	   	 			for(var key in json){
	   	 				var $form_element = $("[name='"+key+"']",part_form);
	   	 				var tagName = $form_element.prop("tagName");
	   	 				if(tagName){
		   	 			 	var element_tagName = tagName.toLowerCase();
		   	 			 	
		   	 			 	switch(element_tagName){
		   	 			 	
		   	 			 	case 'textarea'://textarea
		   	 			 		$form_element.removeAttr("readonly");
		   	 			 		break;
		   	 			 	case 'select'://select
		   	 			 		$form_element.prop('disabled',false);
		   	 			 		$form_element.selectpicker('refresh');
		   	 			 		break;
		   	 			 	default://default  input element
		   	 			 		if($form_element.hasClass("form-date")){//日期类型
		   	 			 			$form_element.data("toggle","datepicker");
		   	 			 		}else{//一般类型的input
		   	 			 			$form_element.removeAttr("readonly");
		   	 			 		}
		   	 			 		break;
		   	 			 	}
	   	 				}
	   	 			 	
	   	 			}
	   	 			$("#isPrivillege", part_form).val("0");
	   	 		}
	   	 	});
   	 	}
	    
	});
	
});
