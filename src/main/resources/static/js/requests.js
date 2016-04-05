$('#div-loading').hide();
$('#div-loading').height($('body').height());

function updateEnviroment(enviroment){
	$.ajax({
	    url : "/migrate/"+enviroment,
	    type: "GET",
	    beforeSend: function(){$('#div-loading').show();},
   		error: function(){$('#div-loading').hide();},
	    success: function(data, textStatus, jqXHR) { setTimeout(function(){ location.reload(); }, 1000);}
	});	
}

function baselineEnviroment(enviroment){
	$.ajax({
	    url : "/baseline/"+enviroment,
	    type: "GET",
	    beforeSend: function(){$('#div-loading').show();},
   		error: function(){$('#div-loading').hide();},
	    success: function(data, textStatus, jqXHR) { setTimeout(function(){ location.reload(); }, 1000);}
	});	
}