<!--
	Authors: Joe Miao and David Roman

	This web application shows the courses that will be offered the
	next term at Knox College. 
-->

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta http-equiv="Content-Language" content="en" />
	<meta name="title" content="Spring 2015| Knox Course Schedule" />
	<meta name="keywords" content="knox college,course schedule,schedule,knox" />
	<meta name="description" content="This application allows you to quickly search the Knox College course schedule using a web form." />
	<meta name="author" content="Zeyu Miao，David Roman ">	
	<link href="styles.css" rel="stylesheet" type="text/css" media="screen" charset="utf-8" />
	<title>Spring 2015 | Knox Course Schedule</title>
</head>

<body>
	<div id="header">
		<div id="logobox" class="central"><img src="logo.png" class="medium" alt="knoxlogo" /> </div>
	</div>

	<div id="main" class="central">
		<div id="title">
			<center><h1>Course Schedule Spring 2015</h1></center>
		</div>

		<div id="info">
				<table style="float:left" cellspacing="3" >
					<tr> 
					<td id="time" colspan="6" align="center">----Time of Class Periods----</td>
					</tr>
					<tr>
						<td>Period 1</td>
						<td>8:00 - 9:10</td>
						<td>Period 3</td>
						<td>10:40 - 11:50</td>
						<td>Period 5</td>
						<td>1:20 - 2:30</td>
					</tr>
					<tr>
						<td>Period 2</td>
						<td>9:20 - 10:30</td>
						<td>Period 3s</td>
						<td>10:40 - 12:10</td>
						<td>Period 5s</td>
						<td>1:0 - 2:30</td>
					</tr>
					<tr>
						<td>Period 2s</td>
						<td>9:00 - 10:30</td>
						<td>Period 4</td>
						<td>12:00 - 1:10</td>
						<td>Period 6</td>
						<td>2:40 - 3:50</td>
					</tr>
				</table>

				<table style="float:left; margin-left:10px;" >
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>SU - Designates courses</td>
					</tr>
					<tr>
						<td>graded Satisfactory</td>
					</tr>
					<tr>
						<td>or Unsatisfactory</td>
					</tr>
				</table>


				<table style="float:left; margin-left:36px;" >
					<tr>
						<td align="center" colspan="2">----------------------Foundation Area Symbols----------------------</td>
					</tr>
					<tr>
						<td>ARTS - Arts</td>
						<td>HUM - Humanities</td>
					</tr>
					<tr>
						<td>HSS - History and Social Sciences</td>
						<td>MNS - Math and Natural Sciences</td>
					</tr>
					<tr>
						<td>NPS - Natural and Physical Sciences </td>
						<td>QSR - Quantitative and Symbolic Reasoning </td>
					</tr>
					
				</table>
				<div style="clear:left"></div>
		</div>

		<div id="searchPanel">
			<form method="get" action="index.php">
				<b>Select department:</b> <select name="dept">
					<option value="all">All departments</option>
					<option value="AFST">Africana Studies</option>
					<option value="AMST">American History</option>
					<option value="ANSO">Anthropology & Sociology</option>
					<option value="ART">Art</option>
					<option value="ASIA">Asian Studies</option>
					<option value="BCHM">Biochemistry</option>
					<option value="BIOL">Biology</option>
					<option value="BKST">Black Studies</option>
					<option value="BUS">Business</option>
					<option value="CTL">Center For Teaching And Learning</option>
					<option value="CHEM">Chemistry</option>
					<option value="CHIN">Chinese</option>
					<option value="CLAS">Classics</option>
					<option value="CS">Computer Science</option>
					<option value="CRWR">Creative Writing</option>
					<option value="DANC">Dance</option>
					<option value="EART">Earth Science</option>
					<option value="ECON">Economics</option>
					<option value="EDUC">Educational Studies</option>
					<option value="ENG">English Literature</option>
					<option value="ENVS">Environmental Studies</option>
					<option value="FILM">Film Studies</option>
					<option value="FREN">French</option>
					<option value="FREN">French</option>
      				<option value="GWST">Gender & Women's Studies</option>
      				<option value="GERM">German</option>
      				<option value="GRK">Greek</option>
      				<option value="GRO">Green Oaks Term</option>
      				<option value="HIST">History</option>
      				<option value="IDIS">Interdisciplinary</option>
      				<option value="IIS">Integrated International Studies</option>
     				<option value="IR">International Relations</option>
      				<option value="JAPN">Japanese</option>
      				<option value="JOUR">Journalism</option>
      				<option value="LAST">Latin American Studies</option>
      				<option value="LAT">Latin</option>
      				<option value="MATH">Mathematics</option>
      				<option value="MCNR">McNair</option>
      				<option value="MODL">Modern Languages</option>
      				<option value="MUS">Music</option>
      				<option value="NEUR">Neuroscience</option>
      				<option value="PCPP">Peace Corps Preparatory Program</option>
      				<option value="PHIL">Philosophy</option>
      				<option value="PHYS">Physics</option>
      				<option value="PREC">First-Year Preceptorial</option>
      				<option value="PS">Political Science</option>
      				<option value="LAW">Prelaw</option>
      				<option value="PSYC">Psychology</option>
      				<option value="RELS">Religious Studies</option>
      				<option value="SSRV">Social Service</option>
      				<option value="SPAN">Spanish</option>
      				<option value="SPST">Sports Studies</option>
      				<option value="STAT">Statistics</option>
      				<option value="THTR">Theatre</option>
      			</select>





					
			
				<br />

				<b>Credits:</b> 
				<input type="radio" name="cr" value="all" CHECKED /> All 
				<input type="radio" name="cr" value="1" /> 1.0 
				<input type="radio" name="cr" value="lt1"/> less or greater 1.0 
				<br />



				<b>Select Foundations:</b> 
				<input type="checkbox" name="ART" />Arts 
				<input type="checkbox" name="HSS" />History and Social Sciences 
				<input type="checkbox" name="HUM" />Humanities 
				<input type="checkbox" name="MNS" />Math and Natural Sciences 
				<input type="checkbox" name="NPS" />Natural and Physical Sciences 
				<input type="checkbox" name="QSR" />Quantitative and Symbolic Reasoning
				<br />



				<b>Requirements:</b> 
				<input type="checkbox" name="DV" /> Diversity 
				<input type="checkbox" name="W" /> Writing 
				<input type="checkbox" name="O" /> Oral
				<br />



				<b>Periods:</b> 
				<input type="checkbox" name="p1" /> 1 
				<input type="checkbox" name="p2" /> 2 
				<input type="checkbox" name="p2s" /> 2s 
				<input type="checkbox" name="p3" /> 3 
				<input type="checkbox" name="p3s" /> 3s 
				<input type="checkbox" name="p4" /> 4 
				<input type="checkbox" name="p5" /> 5 
				<input type="checkbox" name="p5s" /> 5s 
				<input type="checkbox" name="p6" /> 6 
				<input type="checkbox" name="pO" /> Other
				<br />
				<br />

				<input type="submit" value="Search" name="submit" /> <input type="button" value="Reset form" onclick="parent.location='index.php'"/>
			</form>
		</div>

		
		<div id="courseListing">

				<?php

					//ini_set('display_errors', 'On');
					//error_reporting(E_ALL | E_STRICT);

					require_once("dbutils.php");
					$conn = connect();

					//Array that will help processing and indicating the creation of a new table per subject
					$deptArray = array( 
						"AFST" => "Africana Studies",
						"AMST" => "American History",
						"ANSO" => "Anthropology & Sociology",
						"ART" => "Art",
						"ASIA" => "Asian Studies",
						"BCHM" => "Biochemistry",
						"BIOL" => "Biology",
						"BKST" => "Black Studies",
						"BUS" => "Business",
						"CTL" => "Center For Teaching And Learning",
						"CHEM" => "Chemistry",
						"CHIN" => "Chinese",
						"CLAS"=> "Classics",
						"CS" => "Computer Science",
						"CRWR" => "Creative Writing",
						"DANC" => "Dance",
						"EART" => "Earth Science",
						"ECON" => "Economics",
						"EDUC" => "Educational Studies",
						"ENG" => "English Literature",
						"ENVS" => "Environmental Studies",
						"FILM" => "Film Studies",
						"FREN" => "French",
						"FREN" => "French",
		  				"GWST" => "Gender & Women's Studies",
		  				"GERM" => "German",
		  				"GRK" => "Greek",
		  				"GRO" => "Green Oaks Term",
		  				"HIST" => "History",
		  				"IDIS" => "Interdisciplinary",
		  				"IIS" => "Integrated International Studies",
		 				"IR" => "International Relations",
		  				"JAPN" => "Japanese",
		  				"JOUR" => "Journalism",
		  				"LAST" => "Latin American Studies",
		  				"LAT" => "Latin",
		  				"MATH" => "Mathematics",
		  				"MCNR" => "McNair",
		  				"MODL" => "Modern Languages",
		  				"MUS" => "Music",
		  				"NEUR" => "Neuroscience",
		  				"PCPP" => "Peace Corps Preparatory Program",
		  				"PHIL" => "Philosophy",
		  				"PHYS" => "Physics",
		  				"PREC" => "First-Year Preceptorial",
		  				"PS" => "Political Science",
		  				"LAW" => "Prelaw",
		  				"PSYC" => "Psychology",
		  				"RELS" => "Religious Studies",
		  				"SSRV" => "Social Service",
		  				"SPAN" => "Spanish",
		  				"SPST" => "Sports Studies",
		  				"STAT" => "Statistics",
		  				"THTR" => "Theatre"
      				);

					
					$linkDept = array( 
						"AFST" => "http://www.knox.edu/academics/majors-and-minors/africana-studies/courses",
						"AMST" => "http://www.knox.edu/academics/majors-and-minors/american-studies/courses",
						"ANSO" => "http://www.knox.edu/academics/majors-and-minors/anthropology-and-sociology/courses",
						"ART" => "http://www.knox.edu/academics/majors-and-minors/art/courses",
						"ASIA" => "http://www.knox.edu/academics/majors-and-minors/asian-studies/courses",
						"BCHM" => "http://www.knox.edu/academics/majors-and-minors/biochemistry/courses",
						"BIOL" => "http://www.knox.edu/academics/majors-and-minors/biology/courses",
						"BKST" => "http://www.knox.edu/academics/majors-and-minors/africana-studies/courses",
						"BUS" => "http://www.knox.edu/academics/majors-and-minors/business-and-management/courses",
						"CTL" => "http://www.knox.edu/offices/academic-affairs/center-for-teaching-and-learning",
						"CHEM" => "http://www.knox.edu/academics/majors-and-minors/chemistry/courses",
						"CHIN" => "http://www.knox.edu/academics/majors-and-minors/chinese/courses",
						"CLAS"=> "http://www.knox.edu/academics/majors-and-minors/classics/courses",
						"CS" => "http://www.knox.edu/academics/majors-and-minors/computer-science/courses",
						"CRWR" => "http://www.knox.edu/academics/majors-and-minors/creative-writing/courses",
						"DANC" => "http://www.knox.edu/academics/majors-and-minors/dance/courses",
						"EART" => "http://www.knox.edu/academics/majors-and-minors/environmental-studies/courses",
						"ECON" => "http://www.knox.edu/academics/majors-and-minors/economics/courses",
						"EDUC" => "http://www.knox.edu/academics/majors-and-minors/education/courses",
						"ENG" => "http://www.knox.edu/academics/majors-and-minors/english-literature/courses",
						"ENVS" => "http://www.knox.edu/academics/majors-and-minors/environmental-studies/courses",
						"FILM" => "http://www.knox.edu/academics/majors-and-minors/film-studies",
						"FREN" => "http://www.knox.edu/academics/majors-and-minors/french/courses",
		  				"GWST" => "http://www.knox.edu/academics/majors-and-minors/gender-and-womens-studies/courses",
		  				"GERM" => "http://www.knox.edu/academics/majors-and-minors/german/courses",
		  				"GRK" => "http://www.knox.edu/academics/majors-and-minors/classics",
		  				"GRO" => "http://www.knox.edu/academics/immersive-learning/green-oaks-term",
		  				"HIST" => "http://www.knox.edu/academics/majors-and-minors/history/courses",
		  				"IDIS" => "http://www.knox.edu/offices/registrar/catalog/depts-and-courses-of-study/interdisciplinary",
		  				"IIS" => "http://www.knox.edu/academics/majors-and-minors/integrated-international-studies/courses",
		 				"IR" => "http://www.knox.edu/academics/majors-and-minors/international-relations/courses",
		  				"JAPN" => "http://www.knox.edu/academics/majors-and-minors/japanese/courses",
		  				"JOUR" => "http://www.knox.edu/academics/majors-and-minors/journalism/courses",
		  				"LAST" => "http://www.knox.edu/academics/majors-and-minors/latin-american-studies/courses",
		  				"LAT" => "http://www.knox.edu/academics/majors-and-minors/classics/courses",
		  				"MATH" => "http://www.knox.edu/academics/majors-and-minors/mathematics/courses",
		  				"MCNR" => "http://www.knox.edu/offices/academic-affairs/mcnair-scholars-program",
		  				"MODL" => "http://www.knox.edu/academics/majors-and-minors/modern-languages/courses",
		  				"MUS" => "http://www.knox.edu/academics/majors-and-minors/music/courses",
		  				"NEUR" => "http://www.knox.edu/academics/majors-and-minors/neuroscience/courses",
		  				"PCPP" => "http://www.knox.edu/academics/majors-and-minors/peace-corps-preparatory-program/requirements-for-the-program",
		  				"PHIL" => "http://www.knox.edu/academics/majors-and-minors/philosophy/courses",
		  				"PHYS" => "http://www.knox.edu/academics/majors-and-minors/physics/courses",
		  				"PREC" => "http://www.knox.edu/academics/a-knox-education/first-year-preceptorial",
		  				"PS" => "http://www.knox.edu/academics/majors-and-minors/political-science/courses",
		  				"LAW" => "http://www.knox.edu/academics/majors-and-minors/law",
		  				"PSYC" => "http://www.knox.edu/academics/majors-and-minors/psychology/courses",
		  				"RELS" => "http://www.knox.edu/academics/majors-and-minors/religious-studies/courses",
		  				"SSRV" => "http://www.knox.edu/academics/majors-and-minors/social-service",
		  				"SPAN" => "http://www.knox.edu/academics/majors-and-minors/spanish/courses",
		  				"SPST" => "http://www.knox.edu/academics/majors-and-minors/sports-studies/experiences-and-opportunities",
		  				"STAT" => "http://www.knox.edu",
		  				"THTR" => "http://www.knox.edu/academics/majors-and-minors/theatre/courses"
      				);


					

					//Get the parameters for Department
					$department_query="";

					if(isset($_GET[dept])){

						if($_GET[dept] != "all"){
							$department_query = " AND cs.department='$_GET[dept]'";
						}

					}

					//echo $department_query."<br/>";


					//Get parameters for Credits
					$credit_query="";

					if(isset($_GET[cr])){
						if($_GET[cr] == "all"){
							$credit_query = "";
						}
						else if($_GET[cr] == "1"){
							$credit_query = " AND cat.credits='1'";
						}
						else if($_GET[cr] == "lt1"){
							$credit_query = " AND cat.credits<>'1'";
						}

					}

					//echo $credit_query."<br/>";

					
					//Get parameters for Foundations
					$foundation_query="";

					if(isset($_GET[ART])){
						$foundation_query=$foundation_query." cat.foundation='ARTS' OR";
					}
					
					if(isset($_GET[HSS])){
						$foundation_query=$foundation_query." cat.foundation='HSS' OR";
					}
					if(isset($_GET[HUM])){
						$foundation_query=$foundation_query." cat.foundation='HUM' OR";
					}
					if(isset($_GET[MNS])){
						$foundation_query=$foundation_query." cat.foundation='MNS' OR";
					}
					if(isset($_GET[NPS])){
						$foundation_query=$foundation_query." cat.foundation2='NPS' OR";
					}
					if(isset($_GET[QSR])){
						$foundation_query=$foundation_query." cat.foundation2='QSR' OR";
					}
					
					if($foundation_query != ""){
						$foundation_query = substr($foundation_query, 0, -2);
						$foundation_query = " AND (".$foundation_query.")";
					}

					//echo $foundation_query."<br/>";
					
					//Get parameters for Requirements
					$requirement_query="";

					if(isset($_GET[W])){
						$requirement_query=$requirement_query." cat.writing='W' OR";
					}
					
					if(isset($_GET[DV])){
						$requirement_query=$requirement_query." cat.diversity='DV' OR";
					}
					if(isset($_GET[O])){
						$requirement_query=$requirement_query." cat.speaking='O' OR";
					}
					
					
					if($requirement_query != ""){
						$requirement_query = substr($requirement_query, 0, -2);
						$requirement_query = " AND (".$requirement_query.")";
					}

					//echo $requirement_query."<br/>";


					//Get parameters for Periods
					$period_query="";

					if(isset($_GET[p1])){
						$period_query=$period_query." cs.period='1' OR";
					}
					
					if(isset($_GET[p2])){
						$period_query=$period_query." cs.period='2' OR";
					}
					if(isset($_GET[p2s])){
						$period_query=$period_query." cs.period='2s' OR";
					}
					if(isset($_GET[p3])){
						$period_query=$period_query." cs.period='3' OR";
					}
					if(isset($_GET[p3s])){
						$period_query=$period_query." cs.period='3s' OR";
					}
					if(isset($_GET[p4])){
						$period_query=$period_query." cs.period='4' OR";
					}
					if(isset($_GET[p5])){
						$period_query=$period_query." cs.period='5' OR";
					}
					if(isset($_GET[p5s])){
						$period_query=$period_query." cs.period='5s' OR";
					}
					if(isset($_GET[p6])){
						$period_query=$period_query." cs.period='6' OR";
					}
					
					if(isset($_GET[p0])){
						$period_query=$period_query." (cs.period < >'1' AND cs.period < >'2' AND cs.period < >'2s' AND cs.period < >'3' AND 
													cs.period < >'3s' AND cs.period < >'4' AND cs.period < >'5' AND cs.period < >'5s' 
													AND cs.period < >'6')  OR";
					}
					
					
					if($period_query != ""){
						$period_query = substr($period_query, 0, -2);
						$period_query = " AND (".$period_query.")";
					}

					//echo $period_query."<br/>";

					$total_query = $department_query.$credit_query.$foundation_query.$requirement_query.$period_query;

					//echo $total_query;

					/*
					$query = "SELECT cs.department, cs.code, cs.section, cs.courseTitle, cs.faculty, cs.period, cs.days, cs.su, 
								cat.foundation, cat.foundation2, cat.writing, cat.speaking, cat.diversity, cat.prereqs, cat.description, cat.credits, cat.crosslist 
								FROM courseschedule cs LEFT OUTER JOIN catalog cat ON cs.code = cat.course WHERE 1".$total_query;
					*/
					
					
					$query = "SELECT tb.department, tb.code, tb.section, tb.courseTitle, tb.faculty, tb.period, tb.days, tb.su, tb.foundation, tb.foundation2, tb.writing, tb.speaking, tb.diversity, tb.prereqs, tb.description, tb.credits, tb.crosslist,
									 lb.code, lb.labTitle ,lb.section, lb.period, lb.days, lb.faculty, lb.department
									FROM (
										SELECT cs.department, cs.code, cs.section, cs.courseTitle, cs.faculty, cs.period, cs.days, cs.su, cat.foundation, cat.foundation2, cat.writing, cat.speaking, cat.diversity, cat.prereqs, cat.description, cat.credits, cat.crosslist
										FROM courseschedule cs
										LEFT OUTER JOIN catalog cat ON cs.code = cat.course
										WHERE 1 $total_query
									)tb
									LEFT OUTER JOIN labs lb ON lb.parentcourse = tb.code
									ORDER BY tb.code";
					
					

					//echo "$query";
					
					
					
					$stmt = $conn->prepare($query) or die ("Could not execute query" . $conn->error);
					$stmt->execute();
					$stmt->bind_result($department, $code, $section, $courseTitle, $faculty, $period, $days, $su, 
								$foundation, $foundation2, $writing, $speaking, $diversity, $prereqs, $description, $credits, $crosslist,
								$labCode, $labTitle , $labSection, $labPeriod, $labDays, $labFaculty, $labDepartment);
					
					

					$counter = 0;
					$previous = "";
					$rowStyle1 ="";
					$rowStyle2 ="";


				
					while ($stmt->fetch()) {


						//If Statement that checks to print the title and initiation of a table
						if($previous != $department){

							if($counter != 0){
								echo "</table> 
									   <br/>";
							}

							echo "<div style=\"font-size:14px;font-weight:700;\">
									<div class=\"departmentTitle\">
									<a href=\"$linkDept[$department]\" target=\"_blank\" decoration=\"none\">
										$deptArray[$department]
									</a>
									</div>
								  </div>
								  



								  <br />
							      <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\">
										<tr>
											<td class=\"tb-head\">Code</td>
											<td class=\"tb-head\">Course Title</td>
											<td class=\"tb-head\"><center>Cr</center></td>
											<td class=\"tb-head\"><center>Found</center></td>
											<td class=\"tb-head\"><center>Found 2</center></td>
											<td class=\"tb-head\"><center>DV</center></td>
											<td class=\"tb-head\"><center>W</center></td>
											<td class=\"tb-head\"><center>O</center></td>
											<td class=\"tb-head\"><center>Prereqs</center></td>
											<td class=\"tb-head\"><center>Period</center></td>
											<td class=\"tb-head\"><center>Days</center></td>
											<td class=\"tb-head\"><center>Faculty</center></td>
											<td class=\"tb-head\"><center>SU</center></td>
											<td class=\"tb-head\"><center>Crosslist</center></td>
									    </tr>";

						}

						//Defines the type of style of color of each cell
						
						if(($counter % 2) == 0){
							$rowStyle1 = "td-dark";
							$rowStyle2 = "td-light";
						}
						else{
							$rowStyle1 = "td-light";
							$rowStyle2 = "td-dark";
						}
						
								
						if(($prereqs != "---" ) && ($prereqs != NULL )){
							echo"<tr>
									<td style=\"width:100px;\" class=\"$rowStyle1\"> $code - $section </td>

									<td style=\"width:330px;\" class=\"$rowStyle1\">
											<div class=\"popup\">
												<a href=\"#\">$courseTitle
													<div class=\"prereqs\"p>$description
													</div>
												</a>
											</div>
									</td>


									<td style=\"width:25px;\" class=\"$rowStyle1\"><center>$credits</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle1\"><center>$foundation</center></td>
									<td style=\"width:50px;\" class=\"$rowStyle1\"><center>$foundation2</center></td>
									<td style=\"width:35px;\" class=\"$rowStyle1\"><center>$diversity</center></td>
									<td style=\"width:30px;\" class=\"$rowStyle1\"><center>$writing</center></td>
									<td style=\"width:30px;\" class=\"$rowStyle1\"><center>$speaking</center></td>
									
									<td style=\"width:90px;\" class=\"$rowStyle1\"><center>
											<div class=\"popup\">
												<a href=\"#\">View Prereqs
													<div class=\"prereqs\">$prereqs
													</div>
												</a>
											</div>
										</center>
									</td>

									<td style=\"width:50px;\" class=\"$rowStyle1\"><center>$period</center></td>
									<td style=\"width:50px;\" class=\"$rowStyle1\"><center>$days</center></td>
									<td style=\"width:60px;\" class=\"$rowStyle1\"><center>$faculty</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle1\"><center>$su</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle1\"><center>$crosslist</center></td>
							</tr>";
						}
						else{
							echo"<tr>
									<td style=\"width:100px;\" class=\"$rowStyle1\"> $code - $section </td>

									<td style=\"width:340px;\" class=\"$rowStyle1\">
											<div class=\"popup\">
												<a href=\"#\">$courseTitle
													<div class=\"prereqs\"p>$description
													</div>
												</a>
											</div>
									</td>

									<td style=\"width:25px;\" class=\"$rowStyle1\"><center>$credits</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle1\"><center>$foundation</center></td>
									<td style=\"width:50px;\" class=\"$rowStyle1\"><center>$foundation2</center></td>
									<td style=\"width:35px;\" class=\"$rowStyle1\"><center>$diversity</center></td>
									<td style=\"width:30px;\" class=\"$rowStyle1\"><center>$writing</center></td>
									<td style=\"width:30px;\" class=\"$rowStyle1\"><center>$speaking</center></td>
									<td style=\"width:80px;\" class=\"$rowStyle1\"><center>-</center></td>
									<td style=\"width:50px;\" class=\"$rowStyle1\"><center>$period</center></td>
									<td style=\"width:50px;\" class=\"$rowStyle1\"><center>$days</center></td>
									<td style=\"width:60px;\" class=\"$rowStyle1\"><center>$faculty</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle1\"><center>$su</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle1\"><center>$crosslist</center></td>
							</tr>";
						}

						
						if($labCode != NULL){
							echo"<tr>
									<td style=\"width:100px;\" class=\"$rowStyle2\"> $labCode - $labSection </td>

									<td style=\"width:340px;\" class=\"$rowStyle2\">
											<div class=\"popup\">
												<a href=\"#\">$labTitle
												</a>
											</div>
									</td>

									<td style=\"width:25px;\" class=\"$rowStyle2\"><center>---</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle2\"><center>---</center></td>
									<td style=\"width:50px;\" class=\"$rowStyle2\"><center>---</center></td>
									<td style=\"width:35px;\" class=\"$rowStyle2\"><center>---</center></td>
									<td style=\"width:30px;\" class=\"$rowStyle2\"><center>---</center></td>
									<td style=\"width:30px;\" class=\"$rowStyle2\"><center>---</center></td>
									<td style=\"width:80px;\" class=\"$rowStyle2\"><center>-</center></td>
									<td style=\"width:50px;\" class=\"$rowStyle2\"><center>$labPeriod</center></td>
									<td style=\"width:50px;\" class=\"$rowStyle2\"><center>$labDays</center></td>
									<td style=\"width:60px;\" class=\"$rowStyle2\"><center>$labFaculty</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle2\"><center>---</center></td>
									<td style=\"width:45px;\" class=\"$rowStyle2\"><center>---</center></td>
							</tr>";		

							++$counter;	
						

						}
						

						$previous = $department;
						++$counter;

					}

					echo "</table>";	
				?>
			<br />
		</div>

	</div>

	<footer>
		<center>Powered by Zeyu Miao '15 and David Roman '15 &copy; 2015</center><br />
	</footer>
</body>
</html>
