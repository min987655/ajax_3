<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Baseball</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="/ajax1/css/styles.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<div class="d-inline-flex m-3">
			<table class="table table-hover mt-3">
				<thead>
					<tr>
						<th colspan="2" style="border-top-style: none; border-bottom-style: none; font-size: 35px">KBOTeam</th>
					</tr>
					<tr>
						<th style="width: 150px; text-align: center;">번호</th>
						<th style="width: 150px; text-align: center;">팀명</th>
					</tr>
				</thead>
				<tbody id="kboTeam__list">
					<c:forEach var="kboTeam" items="${kboTeams}">
						<tr id="kboTeam-${kboTeam.id}" onclick="playerList(${kboTeam.id});">
							<td style="text-align: center; cursor: pointer;">${kboTeam.id}</td>
							<td style="text-align: center; cursor: pointer;">${kboTeam.teamName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="d-inline-flex m-3">
			<table class="table table-hover mt-3">
				<thead>
					<tr>
						<th colspan="2" style="border-top-style: none; border-bottom-style: none; font-size: 35px">TeamPlayers</th>
					</tr>
					<tr>
						<th style="width: 150px; text-align: center;">번호</th>
						<th style="width: 150px; text-align: center;">이름</th>
					</tr>
				</thead>
				<tbody id="players__list">
					<c:forEach var="players" items="${playersList}">
						<tr id="players-${players.id}">
							<td style="text-align: center;">${players.id}</td>
							<td style="text-align: center;">${players.playerName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="d-inline-flex m-3">
			<table class="table table-hover mt-3">
				<thead>
					<tr>
						<th colspan="2" style="border-top-style: none; border-bottom-style: none; font-size: 35px">Player</th>
					</tr>
					<tr>
						<th style="width: 130px; text-align: center;">번호</th>
						<th style="width: 130px; text-align: center;">이름</th>
						<th style="width: 130px; text-align: center;">포지션</th>
					</tr>
				</thead>
				<tbody id="player__list">
					<c:forEach var="players" items="${playersList}">
						<tr id="players-${players.id}">
							<td style="text-align: center;">${players.id}</td>
							<td style="text-align: center;">${players.playerName}</td>
							<td style="text-align: center;">${players.position}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

<script src="/ajax3/js/home.js"></script>

</body>
</html>