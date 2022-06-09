// - global -------------------------------------------------------------------
var screenCanvas, info;
var run = true;
var fps = 1000 / 30;
var mouse = new Point();
var ctx; // canvas2d コンテキスト格納用
var fire = true;
var counter = 0;

var CHARA_COLOR = 'rgba(0,0,255,0.75)';
var CHARA_SHOT_COLOR = 'rgba(0,255,0,0.75)';
var ENEMY_COLOR = 'rgba(255,0,0,0.75)';

// - main ---------------------------------------------------------------------
window.onload = function(){

    // スクリーンの初期化
    screenCanvas = document.getElementById('screen');
    screenCanvas.width = 1280;
    screenCanvas.height = 600;

    // 2dコンテキスト
    ctx = screenCanvas.getContext('2d');

    // イベントの登録
    screenCanvas.addEventListener('mousemove', mouseMove, true);
    window.addEventListener('keydown', keyDown, true);

    // その他のエレメント関連
    info = document.getElementById('info');

	var chara = new Character();
	
//	var charaShot = new Array();
//	var charaShot[] = new CharacterShot();
	var enemy = new Array();
	
	chara.init(10);

    // レンダリング処理を呼び出す
    (function(){
        // HTMLを更新
        info.innerJSP = mouse.x + ' : ' + mouse.y;

        // screenクリア 
        ctx.clearRect(0, 0, screenCanvas.width, screenCanvas.height);

        // パスの設定を開始
        ctx.beginPath();
        
        chara.position.x = mouse.x;
        chara.position.y = mouse.y;
        		
        ctx.arc(
			chara.position.x, 
			chara.position.y, 
			chara.size, 
			0, Math.PI * 2, false
		);
		        // 円の色を設定する
        ctx.fillStyle = CHARA_COLOR;
	    // 円を描く
        ctx.fill();

//		// エネミーの出現管理 -------------------------------------------------
//		// 100 フレームに一度出現させる
//		if(counter % 100 === 0){
//		    // すべてのエネミーを調査する
//		    for(i = 0; i < ENEMY_MAX_COUNT; i++){
//		        // エネミーの生存フラグをチェック
//		        if(!enemy[i].alive){
//		            // タイプを決定するパラメータを算出
//		            j = (counter % 200) / 100;
//		
//		            // タイプに応じて初期位置を決める
//		            var enemySize = 15;
//		            p.x = -enemySize + (screenCanvas.width + enemySize * 2) * j
//		            p.y = screenCanvas.height / 2;
//		
//		            // エネミーを新規にセット
//		            enemy[i].set(p, enemySize, j);
//		
//		            // 1体出現させたのでループを抜ける
//		            break;
//		        }
//		    }
//		}
//        // フラグにより再帰呼び出し
//        if(run){setTimeout(arguments.callee, fps);}
//    })();
    
//    //ショット
//        (function(){
//        		if(fire){
//			charaShot[].set(chara.position,3,5);
//		}
//        // パスの設定を開始
//        ctx.beginPath();
//
//        charaShot[].move();
//
//		ctx.arc(
//            charaShot[].position.x,
//            charaShot[].position.y,
//            charaShot[].size,
//            0, Math.PI * 2, false
//        );
//        
//        ctx.closePath();
//        
//	    ctx.fillStyle = CHARA_SHOT_COLOR;
//        // ショットを描く
//        ctx.fill();
//				
        // フラグにより再帰呼び出し
        if(run){setTimeout(arguments.callee, fps);}
    })();
};

// - event --------------------------------------------------------------------
function mouseMove(event){
    // マウスカーソル座標の更新
    mouse.x = event.clientX - screenCanvas.offsetLeft;
    mouse.y = event.clientY - screenCanvas.offsetTop;
}

function keyDown(event){
    // キーコードを取得
    var ck = event.keyCode;

    // Escキーが押されていたらフラグを降ろす
    if(ck === 27){run = false;}
}
