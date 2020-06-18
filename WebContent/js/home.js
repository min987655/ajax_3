function playerList(teamId) {
	
	var data = {
		teamId : teamId
	};
			
	$.ajax({
		type : "POST",
		url : "/ajax3/baseball?cmd=playerListProc",
		data: JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		
		$("#players__list").empty();
		
		for(var players of result) {
		
		var playersItem = `<tr id="players-${players.id}">
		<td style="text-align: center;">${players.id}</td>
		<td style="text-align: center;">${players.playerName}</td>
		</tr>`;
		
		$("#players__list").append(playersItem);
		}
					
	}).fail(function(Error) {
		alert("목록 불러오기 실패");
	});
}