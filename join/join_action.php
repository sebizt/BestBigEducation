<?php
# db 접속
// connect.php 파일의 내용을 그대로 가져옴.
$db_host = "localhost"; 
$db_user = "bigeducation"; 
$db_passwd = "dusrntlf0!";
$db_name = "bigeducation"; 

$conn = new mysqli($db_host, $db_user, $db_passwd, $db_name);

if($conn->connect_error) echo "<h2>접속에 실패하였습니다.</h2>";
else echo "<h2>접속에 성공하였습니다.</h2>";

# form 데이터 읽어오기
$id = $_POST["id"];
$pw = $_POST["pw"];
$l_name= $_POST["l_name"];
$f_name = $_POST["f_name"];

echo "추가할 아이디 {$id}";

# insert sql 작성
$sql = "INSERT INTO user (id, pw, l_name,f_name) VALUES('$id', '$pw', '$l_name','$f_name')";

if($conn->query($sql))echo "도서등록 성공";
else echo "도서등록 실패";

?>