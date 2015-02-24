<?php
	class Response
			{
				public static function loginResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['userKey'] = $data[0];
					$response['projectList'] = $data[1];
					
										
					$json_response = json_encode($response);
					return $json_response;
				}
				
				
				public static function projectListResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['projectList'] = $data;
					
										
					$json_response = json_encode($response);
					return $json_response;
				}
				
				
				
				
				
				
				public static function commonResponse($status,$status_message)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;									
					$json_response = json_encode($response);
					return $json_response;
				}
				
			}

?>