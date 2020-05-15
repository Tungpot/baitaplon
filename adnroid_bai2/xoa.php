<?php
require "connect.php";
$tentu = $_POST['tentu'];
$query =  "DELETE FROM `tbl_tuvung` WHERE tentu = '$tentu' ";
if (mysqli_query($connect, $query)) {

	echo "success";
}
else{
echo "error";
}
?>