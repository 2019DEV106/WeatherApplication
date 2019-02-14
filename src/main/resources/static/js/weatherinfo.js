$("#weatherDetails").submit(function() {
	  var latitudeVal = $("#latitude").val();
	  var longitudeVal = $("#longitude").val();
	  if(latitudeVal == "") {
	    alert('Fill this latitude field');
	    return false;
	  }
	  if(longitudeVal == "") {
		    alert('Fill this longitude field');
		    return false;
		  }
	});
	
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)){
	   alert("Number and decimal only allowed"); 
	   return false;
   }
   return true;
}
