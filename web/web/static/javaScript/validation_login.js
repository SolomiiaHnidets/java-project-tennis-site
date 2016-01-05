$(document).ready(function() {
    $("#auth_form").submit(function(e) {
        //loop through each required field and simply change border color to red for invalid fields       
        $("#auth_form input[required=true], #auth_form select[required=true], #auth_form textarea[required=true]").each(function(){
            
            var proceed = true;
            $(this).css('border-color',''); //reset border color
            if(!$.trim($(this).val())){ //if this field is empty 
                $(this).css('border-color','red'); //change border color to red   
                //alert("Field is empty");
                proceed = false; //set do not proceed flag
            }
                    
            if(proceed){ //everything looks good
            	// getting the value
            	login_func();
                //return; //submit form
            }
            e.preventDefault();
        }); 
    });
});

