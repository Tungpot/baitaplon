<?php 
require"connect.php";

	$mang = array();
	$query = "SELECT * FROM tbl_tuvung ";
	$data = mysqli_query($connect,$query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mang, new tbl_tuvung(
		$row['tentu'],
		$row['phanloai'],
		$row['nghia']));
	}
	echo json_encode($mang);
	class tbl_tuvung
	{
		
		function tbl_tuvung($tentu,$phanloai,$nghia){
		$this->tentu = $tentu;
		$this->phanloai = $phanloai;
		$this->nghia = $nghia;
	}
}
 ?>