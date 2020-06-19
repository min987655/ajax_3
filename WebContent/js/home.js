function playerList(teamId) {
	
	var data = {
		teamId : teamId
	};
			
	$.ajax({
		type : "POST",
		url : "/ajax3/baseball?cmd=playerListProc",
		data: "teamId="+data.teamId,
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		
		$("#players__list").empty();
		
		for(var players of result) {
		
		var playersItem = `<tr id="players-${players.id}" onclick="playerDetail(${players.id});">
								<td style="text-align: center; cursor: pointer;">${players.id}</td>
								<td style="text-align: center; cursor: pointer;">${players.playerName}</td>
						</tr>`
		
		$("#players__list").append(playersItem);
		}
					
	}).fail(function(Error) {
		alert("목록 불러오기 실패");
	});
}

function playerDetail(playerId) {
	
	var data = {
		playerId : playerId
	};
			
	$.ajax({
		type : "POST",
		url : "/ajax3/baseball?cmd=playerDetailProc",
		data: "playerId="+data.playerId,
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		
		$("#player__list").empty();
		
		for(var players of result) {
		
		var playersItem = `<tr id="players-${players.id}">
								<td style="text-align: center;">${players.id}</td>
								<td style="text-align: center;">${players.playerName}</td>
								<td style="text-align: center;">${players.position}</td>
							</tr>`;
		
		$("#player__list").append(playersItem);
		}
					
	}).fail(function(Error) {
		alert("목록 불러오기 실패");
	});
}