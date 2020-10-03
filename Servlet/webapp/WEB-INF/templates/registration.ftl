<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>registration</title>
</head>
<body>
<#if message?has_content>
    <p>${message}</p>
</#if>
<p>REGISTRATION</p>
<form method="post" action="/reg">
    <label>login input</label>
    <input type="text" name="username" placeholder="enter login"/>
    <input type="password" name="password" placeholder="enter password"/>
    <input type="submit"></input>
</form>