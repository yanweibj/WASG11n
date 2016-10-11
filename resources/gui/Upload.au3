#CS
# Upload File dialog
#CE

If $CmdLine[0] < 3 Then
	Exit
EndIf

fileUpload($CmdLine[1], $CmdLine[2], $CmdLine[3])

Func fileUpload($uploadtitle, $uploadfile, $timeout)
	WinWait($uploadtitle,"",$timeout)
	If  WinExists($uploadtitle) Then
		WinActive($uploadtitle)
		Sleep (500)
		ControlSetText($uploadtitle,"","Edit1",$uploadfile)
		ControlClick($uploadtitle, "", 1)
	Else
		Return False
	EndIf
EndFunc