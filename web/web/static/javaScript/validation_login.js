$(document).ready(function() {
    $("#auth_form").submit(function(e) {
    	var proceed = true;
        //loop through each required field and simply change border color to red for invalid fields       
        $("#auth_form input[required=true], #auth_form select[required=true], #auth_form textarea[required=true]").each(function(){
            $(this).css('border-color',''); //reset border color
            if(!$.trim($(this).val())){ //if this field is empty 
                $(this).css('border-color','red'); //change border color to red   
                proceed = false; //set do not proceed flag
            }
                    
            if(proceed){ //everything looks good
                return; //submit form
            }
            e.preventDefault();
        });
        
        if(proceed){ //everything looks good
        	login_func();
        }
        
    });
});

