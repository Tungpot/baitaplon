<?php
require"connect.php";

$tentu = $_POST['tentu'];
$phanloai = $_POST['phanloai'];
$nghia = $_POST['nghia'];
$query = " UPDATE tbl_tuvung SET tentu = '$tentu',phanloai = '$phanloai', nghia = '$nghia' ";
if (mysqli_query($connect, $query)) {

	echo "success";
}
else{
echo "error";
}
?>