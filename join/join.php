<?php # form 데이터 읽어오기
$id = $_POST["id"];
$pw = $_POST["pw"];
$l_name = $_POST["l_name"];
$f_name = $_POST["f_name"];

# insert sql 작성
$con = mysqli_connect("127.0.0.1:5501","user","1234","BestBigEducation") or die ("Can't access DB");
$query = "INSERT INTO user (id, pw, l_name, f_name) VALUES('$id', '$pw', '$l_name', '$f_name')";
$resut=mysqli_query($con,$query);
if(!$result) 
{?>
    <script> alert('회원가입이 완료되었습니다.'); location.href=".."; </script> 
<?php
} else {?>
    <script> alert('회원가입에 실패했습니다.\n다시 시도해 주세요.'); location.href=".."; </script>
<?php } ?>
