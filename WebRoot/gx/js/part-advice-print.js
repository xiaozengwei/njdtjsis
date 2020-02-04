$(function(){
	//意见列表
	 $(".form-advice-list", $.CurrentNavtab).each(function() {
	        var advice_label = $(this);
	        var contol_name = advice_label.attr("control-name");
	        var fwId = advice_label.attr("row-id");
	        var insert_mode = advice_label.attr("insert-mode")||"html";
	        var table_name = "gx_oa_fw";
	        var _url = '../signature/signlist.do';
	        var data = {
	        	rowId: fwId,
	            signControlName: contol_name,
	            tableName: table_name
	        };
	        $.get(_url, data,
	        function(json) {
	            var d_html = "";
	            $.each(json,
	            function(i, sign) {
	                var creatorId = sign.creatorId;
	                var creatorName = sign.creatorName;
	                var controlName = sign.controlName;
	                var optionContext = sign.optionContext;
	                var createTime = sign.createTime;
	                var d = new Date(); d.setTime(createTime); createTime = d.format("yyyy-MM-dd hh:mm:ss");

	                d_html += "<div><div id=\"form-advice_hegao-list\"><div class=\"form-advice\" ><label class=\"control-label x100\">" + optionContext + "</label></div><div   class=\"form-advice_user_and_date\">";
	                var nameflag = controlName != 'additionalComments'; //附加意见不
	                d_html += getSignatureNote(creatorId, creatorName, nameflag);
	                d_html += "<label class=\"control-label x100\" style=\"font-size:12px;\">" + createTime + "</label></div></div></div>";

	            });
	           // $(d_html).prependTo(advice_label);
	            if(d_html.length > 0){
		        	if(insert_mode=='html'){
		        		$(d_html).prependTo(advice_label);
		        	//	advice_label.prependTo(d_html);
		        	}else if(insert_mode=='before'){
		        		$(d_html).insertAfter(advice_label);
		        		//advice_label.insertAfter(d_html);
		        	}
		        }
	        });
	    });
});