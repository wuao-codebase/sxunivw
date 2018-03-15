
$(document).ready(function(){ 
	SelectOne();
	Selectsi();
}); 

function SelectOne() {
        $.ajax({  
            type: "post",  
            url: "/sxunivw/Sanjifind",
            data:{"id":1
            	},
            success: function (strJson) {  
//                alert(JSON.stringify(strJson));  
            	bindselect1(strJson);  
  
            },  
            error: function (XmlHttpRequest, textStatus, errorThrown) {  
                alert(XmlHttpRequest.responseText);  
            }  
        });  

 }
 
function SelectTwo() {  

    var yijizy = document.getElementById("select1");  
    if ("" != yijizy.options[yijizy.selectedIndex].value) {  
        var zydm = yijizy.options[yijizy.selectedIndex].value; 
        $.ajax({  
            type: "post",  
            url: "/sxunivw/Sanjifind",
            data:{"id":2,
            	"zydm":zydm
            },
            success: function (strJson) {    
            	bindselect2(strJson);  
  
            },  
            error: function (XmlHttpRequest, textStatus, errorThrown) {  
                alert(XmlHttpRequest.responseText);  
            }  
        });  
    }  
 }  

function SelectSan() {  

    var erjizy = document.getElementById("select2");  
    if ("" != erjizy.options[erjizy.selectedIndex].value) {  
        var zydm = erjizy.options[erjizy.selectedIndex].value; 
        $.ajax({  
            type: "post",  
            url: "/sxunivw/Sanjifind",
            data:{"id":3,
            	"zydm":zydm
            },
            success: function (strJson) {    
            	bindselect3(strJson);  
  
            },  
            error: function (XmlHttpRequest, textStatus, errorThrown) {  
                alert(XmlHttpRequest.responseText);  
            }  
        });  
    }  
 } 

function Selectsi() {
    $.ajax({  
        type: "post",  
        url: "/sxunivw/Sanjifind",
        data:{"id":4
        	},
        success: function (strJson) {  
//            alert(JSON.stringify(strJson));  
        	bindselect4(strJson);  

        },  
        error: function (XmlHttpRequest, textStatus, errorThrown) {  
            alert(XmlHttpRequest.responseText);  
        }  
    });  
}

function Selectwu() {  

    var yijizy = document.getElementById("select4");  
    if ("" != yijizy.options[yijizy.selectedIndex].value) {  
        var zydm = yijizy.options[yijizy.selectedIndex].value; 
        $.ajax({  
            type: "post",  
            url: "/sxunivw/Sanjifind",
            data:{"id":5,
            	"zydm":zydm
            },
            success: function (strJson) {    
            	bindselect5(strJson);  
  
            },  
            error: function (XmlHttpRequest, textStatus, errorThrown) {  
                alert(XmlHttpRequest.responseText);  
            }  
        });  
    }  
 }  

function Selectliu() {  

    var erjizy = document.getElementById("select5");  
    if ("" != erjizy.options[erjizy.selectedIndex].value) {  
        var zydm = erjizy.options[erjizy.selectedIndex].value; 
        $.ajax({  
            type: "post",  
            url: "/sxunivw/Sanjifind",
            data:{"id":6,
            	"zydm":zydm
            },
            success: function (strJson) {    
            	bindselect6(strJson);  
  
            },  
            error: function (XmlHttpRequest, textStatus, errorThrown) {  
                alert(XmlHttpRequest.responseText);  
            }  
        });  
    }  
 } 


 function bindselect1(strJson) {   
	    var dataArray = eval(strJson);  
	    for (var i = 0; i < dataArray.length; i++) {  
	        //传递参数       
	        $("#select1").append($("<option value='" + dataArray[i].yijidm + "'>" + dataArray[i].yijmc + "</option>"));  
	    } 
	}  
 
 function bindselect2(strJson) {   
	    var dataArray = eval(strJson);  
	    $("#select2").empty();
	    $("#select2").append($("<option >" +' - 请选择 - '+ "</option>"));
	    for (var i = 0; i < dataArray.length; i++) {  
	        //传递参数       
	        $("#select2").append($("<option value='" + dataArray[i].erjidm + "'>" + dataArray[i].erjmc + "</option>"));  
	    } 
	} 
 
 function bindselect3(strJson) {   
	    var dataArray = eval(strJson);  
	    $("#select3").empty();
	    $("#select3").append($("<option >" +' - 请选择 - '+ "</option>"));
	    for (var i = 0; i < dataArray.length; i++) {  
	        //传递参数       
	        $("#select3").append($("<option value='" + dataArray[i].sanjdm + "'>" + dataArray[i].sanjmc + "</option>"));  
	    } 
	} 
 
 function bindselect4(strJson) {   
	    var dataArray = eval(strJson);  
	    for (var i = 0; i < dataArray.length; i++) {  
	        //传递参数       
	        $("#select4").append($("<option value='" + dataArray[i].yijidm + "'>" + dataArray[i].yijimc + "</option>"));  
	    } 
	}  

function bindselect5(strJson) {   
	    var dataArray = eval(strJson);  
	    $("#select5").empty();
	    $("#select5").append($("<option >" +' - 请选择 - '+ "</option>"));
	    for (var i = 0; i < dataArray.length; i++) {  
	        //传递参数       
	        $("#select5").append($("<option value='" + dataArray[i].erjidm + "'>" + dataArray[i].erjdmmc + "</option>"));  
	    } 
	} 

function bindselect6(strJson) {   
	    var dataArray = eval(strJson);  
	    $("#select6").empty();
	    $("#select6").append($("<option >" +' - 请选择 - '+ "</option>"));
	    for (var i = 0; i < dataArray.length; i++) {  
	        //传递参数       
	        $("#select6").append($("<option value='" + dataArray[i].sanjidm + "'>" + dataArray[i].sanjmc + "</option>"));  
	    } 
	} 