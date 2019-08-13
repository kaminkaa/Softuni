<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        X: <input type="text" name="num1" />
		Y: <input type="text" name="num2" />
        Z: <input type="text" name="num3" />
		<input type="submit" />
    </form>
	<!--Write your PHP Script here-->
    <?php
    if (isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3'])) {
        $n1 = intval($_GET['num1']);
        $n2 = intval($_GET['num2']);
        $n3 = intval($_GET['num3']);

        $countNegative = 0;

        if ($n1 < 0) {
            $countNegative ++;
        }
        if ($n2 < 0) {
            $countNegative ++;
        }
        if ($n3 < 0) {
            $countNegative ++;
        }

        if ($n1 == 0 || $n2 == 0 || $n3 == 0) {
            echo 'Positive';
        } else if ($countNegative%2 == 0) {
            echo 'Positive';
        } else {
            echo 'Negative';
        }
    }
    ?>
</body>
</html>