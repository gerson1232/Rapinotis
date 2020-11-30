<?php


    
	   $tipo=$_REQUEST['t1'];
	   $titulo=$_REQUEST['t2'];
	   $noticia=$_REQUEST['t3'];	   
	   $img=$_REQUEST['upload'];
	   $filename="IMG".rand().".jpg";
	   file_put_contents("images/".$filename,base64_decode($img));

	   $servidor="localhost";
	   $usuario="root";
	   $pwd="";
	   $bd="noticiasdb";
	   $cn=new mysqli($servidor,$usuario,$pwd,$bd);

                  

			$qry="INSERT INTO `noticiastb` (`id`, `tipo`, `titulo`, `noticia`, `imagen`) 
			VALUES (NULL, '$tipo', '$titulo', '$noticia', '$filename');";
				  

				  

			$res=mysqli_query($cn,$qry);
			
			if($res==true)
			 echo "File Uploaded Successfully";
			else
			 echo "Could not upload File";
?>
