<?php # form 데이터 읽어오기
$id = $_POST["id"];
$pw = $_POST["pw"];

$db_host = "localhost"; 
$db_user = "bigeducation"; 
$db_passwd = "dusrntlf0!";
$db_name = "bigeducation"; 
$conn = mysqli_connect($db_host,$db_user,$db_passwd,$db_name);
# insert sql 작성
$query = "SELECT pw FROM user WHERE id =  '" . $id . "';";
$result=mysqli_query($con, $query);

if(!$result) 
{?>

    <script> alert('로그인 성공'); location.href=".."; </script> 
<?php
} else { ?>
    <script> alert('로그인 실패 retry.. '); location.href=".."; </script>
    <?php
 }
?>
