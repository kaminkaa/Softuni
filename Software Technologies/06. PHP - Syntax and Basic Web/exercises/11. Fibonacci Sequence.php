<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
	<!--Write your PHP Script here-->
    <?php
    if (isset($_GET['num'])) {
        $n = intval($_GET['num']);
        $reminder1 = 1;
        $reminder2 = 1;
        $result = 0;
        echo $reminder1.' ';
        echo $reminder2.' ';
        for ($i = 0; $i < $n-2; $i++) {
            $result = $reminder1 + $reminder2;
            echo $result.' ';
            $reminder1 = $reminder2;
            $reminder2 = $result;
        }
    }
    ?>
</body>
</html>