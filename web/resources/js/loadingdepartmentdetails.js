function loaddepartment()
        {
            var facultyid=document.getElementById('faculty').value;
           
            var select = document.getElementById('department');
            select.options.length = 0;
            
            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/kmr/loaddepartment.jsp",
                data: 'id=' + facultyid,
                cache: false,
                dataType: "json",
                success: function (data) {
                    var options, index, select, option;

                    // Get the raw DOM object for the select box
                    select = document.getElementById('department');

                    // Clear the old options
                    select.options.length = 0;

                    // Load the new options
                    options = data.options; // Or whatever source information you're working with
                    for (index = 0; index < options.length; ++index) {
                      option = options[index];
                      select.options.add(new Option(option.text, option.value));
                    }
                    
                    if(select.options.length>0)
                    {
                        loaddegree();
                    }
                  }
                
            });
        }
        function loaddegree()
        {
            var facultyid=document.getElementById('department').value;
           
            var select = document.getElementById('degree');
            select.options.length = 0;
            
            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/kmr/loaddegree.jsp",
                data: 'id=' + facultyid,
                cache: false,
                dataType: "json",
                success: function (data) {
                    var options, index, select, option;

                    // Get the raw DOM object for the select box
                    select = document.getElementById('degree');

                    // Clear the old options
                    select.options.length = 0;

                    // Load the new options
                    options = data.options; // Or whatever source information you're working with
                    for (index = 0; index < options.length; ++index) {
                      option = options[index];
                      select.options.add(new Option(option.text, option.value));
                    }
                    
                    if(select.options.length>0)
                    {
                        loadcourse();
                    }
                  }
                
            });
        }
        function loadcourse()
        {
            var facultyid=document.getElementById('degree').value;
           
            var select = document.getElementById('course');
            select.options.length = 0;
            
            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/kmr/loadcourse.jsp",
                data: 'id=' + facultyid,
                cache: false,
                dataType: "json",
                success: function (data) {
                    var options, index, select, option;

                    // Get the raw DOM object for the select box
                    select = document.getElementById('course');

                    // Clear the old options
                    select.options.length = 0;

                    // Load the new options
                    options = data.options; // Or whatever source information you're working with
                    for (index = 0; index < options.length; ++index) {
                      option = options[index];
                      select.options.add(new Option(option.text, option.value));
                    }
                    if(select.options.length>0)
                    {
                        loadyear();
                    }
                  }
                
            });
        }
        
        function loadyear()
        {
            var facultyid=document.getElementById('course').value;
           
            var select = document.getElementById('year');
            select.options.length = 0;
            
            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/kmr/loadyear.jsp",
                data: 'id=' + facultyid,
                cache: false,
                dataType: "json",
                success: function (data) {
                    var options, index, select, option;

                    // Get the raw DOM object for the select box
                    select = document.getElementById('year');

                    // Clear the old options
                    select.options.length = 0;

                    // Load the new options
                    options = data.options; // Or whatever source information you're working with
                    for (index = 0; index < options.length; ++index) {
                      option = options[index];
                      select.options.add(new Option(option.text, option.value));
                    }
                  }
                
            });
        }


