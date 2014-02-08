<?php

include "crawl2.php";
$text=0;
function yahoo($i)
{
	$j=$i;
	$text++;
	$url="http://www.codechef.com/viewplaintext/".$i."";
	$code=file_get_html($url);
	$file=fopen($text.".txt","w");
	fwrite($file,$code);
	fclose();
}

$html=file_get_html("http://www.codechef.com/status/LOWSUM");
$find=$html->find('tr[class=kol] td');
$c=0;
foreach($find as $i)
{	
	if($c%8==0)
	{
		yahoo($i->innertext);
	}
	$c++;
}

?>