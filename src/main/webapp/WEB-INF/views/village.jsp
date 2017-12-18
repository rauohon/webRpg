<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mainpanel">
	<div class="contentpanel">
		<div class="row">
			<div class="col-md-4 dash-left">
				<div class="panel">
					<ul class="panel-options">
						<li><a><i class="fa fa-refresh"></i></a></li>
						<li><a class="panel-remove"><i class="fa fa-remove"></i></a></li>
					</ul>
					<div class="panel-heading">
						<h4 class="panel-title">채팅 공간</h4>
					</div>
					<div id="chatArea" class="panel-body" style="height:600px; background:rgba(0, 0, 0, 0.1);">
						
					</div>
					<div id='chatTalkArea' style='height: 75px; padding-top:2%;'>
						<p style='text-align: center;'>
							<input type="text" id="message" placeholder="전송할 메시지" style="height: 40px;width: 60%;" />
							<input type="button" id="sendBtn" value="전송"  style='height: 45px; width: 20%;'/>
						</p>
					</div>
				</div>
			</div> <!-- left panel -->
			
			<div class="col-md-8 dash-right">
				<div class="panel">
					<div class="panel-heading">
					</div>
					<div class="panel-body" style="font-size: 20px;">
						<div id='charaInfo' style="margin-top: 5%;">
							<button class='btn btn-default' onClick="movePage('characterinfo','CharacterInfo','GET')" style='height:100px; width:49%; font-size:40px; font-family: Jeju Hallasan;'>캐릭터 정보</button>
							<button class='btn btn-default' onClick="movePage('questall','QuestAll','POST')"  style='height: 100px; width: 49%; font-size:40px; font-family: Jeju Hallasan; margin-left: 1%;'>퀘스트</button>
						</div>
						<div id='go_guild'>
							<button class='btn btn-default' onClick="movePage('guild','Guild','POST')" style='height: 100px; width: 99.3%; font-size:40px; font-family: Jeju Hallasan; margin-top: 1%;'>길드</button>
						</div>
						<div id='go_dungeon'>
							<button class='btn btn-default' onClick="movePage('dungeonpage','DungeonPage','POST')" style='height: 100px; width: 99.3%; font-size:40px; font-family: Jeju Hallasan; margin-top: 1%;'>탐험</button>
						</div>
						<div id='go_shop'>
							<button class='btn btn-default' onClick="movePage('shopequip','ShopEquip','GET')" style='height: 100px; width: 49%; font-size:40px; font-family: Jeju Hallasan; margin-top: 1%;'>아이템 상점</button>
							<button class='btn btn-default' onClick="EnhanceShopMove()" style='height: 100px; width: 49%; margin-left: 1%; font-size:40px; font-family: Jeju Hallasan; margin-top: 1%;'>대장간</button>
						</div>
						<div id='go_ranking'>
							<button class='btn btn-default' onClick="movePage('ranking','Ranking','POST')" style='height: 100px; width: 99.3%; font-size:40px; font-family: Jeju Hallasan; margin-top: 1%;'>랭킹</button>
						</div>
					</div><!-- panel-body -->
				</div><!-- panel -->
			</div>
			<!-- right panel -->
		</div>
		<!-- row -->
	</div>
	<!-- contentpanel -->
</div>
<!-- mainpanel -->

<style>
@font-face {
  font-family: 'Jeju Hallasan';
  font-style: normal;
  font-weight: 400;
  src: url(//fonts.gstatic.com/ea/jejuhallasan/v3/JejuHallasan-Regular.eot);
  src: url(//fonts.gstatic.com/ea/jejuhallasan/v3/JejuHallasan-Regular.eot?#iefix) format('embedded-opentype'),
       url(//fonts.gstatic.com/ea/jejuhallasan/v3/JejuHallasan-Regular.woff2) format('woff2'),
       url(//fonts.gstatic.com/ea/jejuhallasan/v3/JejuHallasan-Regular.woff) format('woff'),
       url(//fonts.gstatic.com/ea/jejuhallasan/v3/JejuHallasan-Regular.ttf) format('truetype');
}

</style>