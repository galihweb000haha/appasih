<?php


    require_once('connect.php');

    $query = "SELECT * FROM book JOIN category USING(id_category)";
    $sql   = mysqli_query($db_connect, $query);
    
    $result = array();
    
    if ($sql) {
        $result = array();
        while($row = mysqli_fetch_array($sql)){
            array_push($result, array(
                'id' => $row['id_book'],
                'title' => $row['title'],
                'author' => $row['author'],
                'category' => $row['category'],
            ));
        }

        echo json_encode( array('book' => $result));
    }


?>
