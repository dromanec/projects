<?php

function connect()
{
	$dbhost = 'localhost';
	// replace user and password with your dbbame, i.e. alpha
	$dbuser = 'yankee';
	$dbpass = 'yankee';
	// your dbname will be something like cs262f14alpha
	$dbname = 'cs320yankee';
	$port = 3306;

	$conn=new mysqli($dbhost, $dbuser, $dbpass, $dbname) or die ('Error connecting to mysql' . mysqli_connect_error());
	return $conn;
}


?>
