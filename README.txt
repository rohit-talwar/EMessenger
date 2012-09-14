----------------------------------------------------------
			EMess
----------------------------------------------------------

Emess or Email Messenger. Is a messenger service which uses
the users email accounts to send the messages. 

The class Structure - 

Input - takes the users email address and password and recievers 
email address. Then prompts the user for messages. Also gives 
the user to change the re feed the reciever's address
Calls thre class to run a thread reading the mails recieved
in the users mail box
Calls SendMailTLS to send the input message to the reciever

SendMailTLS - sends the message as a mail to the reciever.

Recieve - Recieves the mails in the users mailbox

thre - A threaded mail reciever.

Protocol - 

The message is the subject of the mail concatenated with 
"Talwar IM" to distinguish it from the other messages.
The message is sent by the username of "TalwarServices", 
enabling the users to delete messages easily.

IMPORTANT - 
Program tested inside collge campus running a proxy server
on port 8080
Tested on gmail ids