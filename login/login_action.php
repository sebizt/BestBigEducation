<?php
$id=$_POST['id'];
$pw=$_POST['pw'];

$db_host = "localhost"; 
$db_user = "bigeducation"; 
$db_passwd = "dusrntlf0!";
$db_name = "bigeducation"; 
$conn = mysqli_connect($db_host,$db_user,$db_passwd,$db_name);

# select sql 작성
$query = "SELECT pw FROM user WHERE id = $id;";
$result=mysqli_query($con, $query);
echo ($result);
if(result === $pw) 
{?>
    <script> alert('로그인 성공'); location.href=".."; </script> 
<?php
} else { ?>
    <script> alert('로그인 실패 retry.. '); location.href=".."; </script>
    <?php
 }
?>
<?php
$db_name = "bigeducation";

$conn = new mysqli($db_host, $db_user, $db_passwd, $db_name);

$check="SELECT * FROM user WHERE id ='$id'";

$result=$conn->query($check); 
if($result->num_rows==1){
    $row=$result->fetch_array(MYSQLI_ASSOC); //하나의 열을 배열로 가져오기
    if($row['pw']==$pw){  //MYSQLI_ASSOC 필드명으로 첨자 가능
        $_SESSION['id']=$id;           //로그인 성공 시 세션 변수 만들기
        if(isset($_SESSION['id']))    //세션 변수가 참일 때
        {
            header('Location: ../index.html');   //로그인 성공 시 페이지 이동
        }
        else{
            echo "세션 저장 실패";
        }            
    }
    else{
        echo "wrong id or pw";
    }
}
else{
    echo "wrong id or pw";
}
?>