// - global -------------------------------------------------------------------
var screenCanvas, info;
var run = true;
var fps = 1000 / 30;
var mouse = new Point();
var ctx; // canvas2d コンテキスト格納用
var fire = false;

var CHARA_COLOR = 'rgba(0,0,255,0.75)';
var CHARA_SHOT_COLOR = 'rgba(0,255,0,0.75)';
var CHARA_SHOT_MAX_COUNT = 10;

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
    screenCanvas.addEventListener('mousedown', mouseDown, true);
    window.addEventListener('keydown', keyDown, true);

    // その他のエレメント関連
    info = document.getElementById('info');

	var chara = new Character();
    chara.init(10);
    var charaShot = new Array(CHARA_SHOT_MAX_COUNT);
    for(i = 0; i < CHARA_SHOT_MAX_COUNT; i++){
        charaShot[i] = new CharacterShot();
    }

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

       // フラグにより再帰呼び出し
       if(run){setTimeout(arguments.callee, fps);}   

   })();

    (function(){
    // パスの設定を開始
    ctx.beginPath();

    // すべての自機ショットを調査する
    for(i = 0; i < CHARA_SHOT_MAX_COUNT; i++){
        // 自機ショットが既に発射されているかチェック
        if(charaShot[i].alive){
            // 自機ショットを動かす
            charaShot[i].move();

            // 自機ショットを描くパスを設定
            ctx.arc(
                charaShot[i].position.x,
                charaShot[i].position.y,
                charaShot[i].size,
                0, Math.PI * 2, false
            );

            // パスをいったん閉じる
            ctx.closePath();
        }
    }
    // fireフラグの値により分岐
    if(fire){
        // すべての自機ショットを調査する
        for(i = 0; i < CHARA_SHOT_MAX_COUNT; i++){
            // 自機ショットが既に発射されているかチェック
            if(!charaShot[i].alive){
                // 自機ショットを新規にセット
                charaShot[i].set(chara.position, 3, 5);

                // ループを抜ける
                break;
            }
        }
        // フラグを降ろしておく
        fire = false;
    }

    // 自機ショットの色を設定する
    ctx.fillStyle = CHARA_SHOT_COLOR;

    // 自機ショットを描く
    ctx.fill();
    })();        
}

// - event --------------------------------------------------------------------
function mouseMove(event){
    // マウスカーソル座標の更新
    mouse.x = event.clientX - screenCanvas.offsetLeft;
    mouse.y = event.clientY - screenCanvas.offsetTop;
}
function mouseDown(event){
    event.mouseDown;
    fire = true;
}
function keyDown(event){
    // キーコードを取得
    var ck = event.keyCode;

    // Escキーが押されていたらフラグを降ろす
    if(ck === 27){run = false;}
}