<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Practice</title>
    <link rel="stylesheet" type="text/css" href="CSS/createPracticeStyles.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#practiceDate").datepicker();
        });

        // Function to check if all fields are filled
        function validateForm() {
            var practiceName = $("#practiceName").val();
            var practiceDate = $("#practiceStartDate").val();
            var practiceLocation = $("#practiceLocation").val();
            var practiceDescription = $("#practiceDescription").val();
            var practiceCapacity = $("#practiceCapacity").val();

            // Check if any field is empty
            if (practiceName == '' || practiceDate == '' || practiceLocation == '' || practiceDescription == '' || practiceCapacity == '') {
                alert("All fields are required!");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>

    <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Create Practice</h1>
    </div>

    <form action= "${pageContext.servletContext.contextPath}/practices" method="post" onsubmit="return validateForm()">
        <div class="container">
            <h2>Practice Details</h2>
            <div class="form-group">
                <label for="practiceName">Practice Name:</label>
                <input type="text" id="practiceName" name="practiceName">
            </div>
            <div class="form-group">
                <label for="practiceDate">Practice Date:</label>
                <input type="text" id="practiceStartDate" name="practiceStartDate">
            </div>
            <div class="form-group">
                <label for="practiceLocation">Practice Location:</label>
                <input type="text" id="practiceLocation" name="practiceLocation">
            </div>
            <div class="form-group">
                <label for="practiceDescription">Practice Description:</label>
                <textarea id="practiceDescription" name="practiceDescription"></textarea>
            </div>
            <div class="form-group">
                <label for="practiceCapacity">Practice Capacity:</label>
                <input type="number" id="practiceCapacity" name="practiceCapacity">
            </div>
            <input type="submit" value="Create Practice">
        </div>
    </form>

</body>

</html>
