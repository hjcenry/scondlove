

	function getnextpage(){
		$.ajax({
			type:"POST",
			url:"../deal/getmoreAssignment",
			data:{"page":$("#nextpage").val(),"rows":$("#rows").val(),"count":$("#totalItem").val(),
				"classify":$("#classify").val()},
			success:function(data){
				if(data.dealMessageList!=null){
					var tab="";
					for(var i=0;i<data.dealMessageList.length;i++){
						tab+='<div id="assign'+data.dealMessageList[i].dealId+'" onclick="getassignDetail('+"'"+data.dealMessageList[i].dealId+"'"+')">';
						tab+='<TABLE class="tab">';
						tab+='<TR><TD class="imgtd"><img src="'+data.dealMessageList[i].userImage+'" class="smartimg" /></TD>';
						tab+='<TD><span class="bluefont">'+data.dealMessageList[i].username+'</span></TD>';
						tab+='<TD align="right"><span class="grayfont" >'+formatdate(data.dealMessageList[i].createTime)+'</span></TD></TR>';
						tab+='<TR><TD></TD>';
						tab+='<TD colspan="2" class="textcon">'+data.dealMessageList[i].dealTitle+'</TD></TR>';
						tab+='<TR><TD></TD>';
						tab+='<TD><img src="'+$("#path").val()+data.dealMessageList[i].dealImage+'" class="middleimg mt10 mb10" /></TD>';
						tab+='<TD></TD></TR>';
						tab+='<TR><TD></TD>';
						tab+='<TD><span class="redfont"></span></TD>';
						tab+='<TD align="right">';
						
						tab+='</TD></TR></TABLE></div>';
					}
					
					$("#lis").append(tab);
					
						
				}
				
				if(data.page!=null){
					$("#page").val(data.page.currentPageIndex);
					if(data.page.currentPageIndex==data.page.pageCount){
						$("#bmore").hide();
					}else{
						$("#nextpage").val(data.page.currentPageIndex+1);
					}
					
				}
				
			}
		});	
	}
	
	
	function formatdate(dates){
		var JsonDateValue = new Date(dates);
		var days=JsonDateValue.getDate();
		var text =(JsonDateValue.getMonth()+1)+"-"+(days<10?("0"+days):days);
		return text;
	}