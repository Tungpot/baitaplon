<?php
require"connect.php";
$tentu = $_POST['tentu'];
$phanloai = $_POST['phanloai'];
$nghia = $_POST['nghia'];

$query = " INSERT INTO tbl_tuvung (tentu,phanloai,nghia) VALUES ( '$tentu', '$phanloai', '$nghia')";
if (mysqli_query($connect, $query)) {

	echo "success";
}
else{
echo "error";
}
?>