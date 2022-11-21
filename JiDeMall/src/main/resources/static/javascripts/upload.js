
//$(document).ready(function(){

var documentW = $(document).width() - 80; //padding锛 40 涓婁笅 -80
var documentH = $(document).height() - 80;
//缂栬緫閫昏緫
$("#editImgs").click(function() {
	$(this).hide();
	$("#uploadImgs").show();
	$("#showImgs").hide();
})
var imgSrc;
//涓婁紶鏃惰皟鐢ㄧ殑涓绘柟娉 
function imgsUpload(imgObj, obj,imgNum) {
    var lastInput = null;
    lastInput = $('.' + fileClass).last(); //绗竴娆℃寚鍚戦粯璁ょ殑input
    $(".uploadImgs-add").click(function () {
        lastInput = $('.' + fileClass).last(); //寰楀埌鏈€鍚庣殑input,濡傛灉鏄疘E锛屼細鐢熸垚澶氫釜, 杩欎釜input鏄伐鍏蜂汉鎬ц川
        $('.' + fileClass).each(function (k, v) {
            $(this).attr('id', '');
        })
        lastInput.attr('id', 'fileUpIpt'); //鍙粰鏈€鍚庝竴涓猧nput姝ｇ‘鐨処D鍊煎拰label鑱斿姩锛屼笉鐢╨abel鑱斿姩  IE9琛屼笉閫氾紝鎻愪氦浼氬け璐 
        lastInput.unbind('change');
        lastInput.bind("change", function () {
            if (lastInput[0].files) { //璋锋瓕 IE10浠ヤ笂          
                var win = window.URL || window.webkitURL;
                imgSrc = win.createObjectURL(lastInput[0].files[0]);
                imgObj.push(imgSrc);            
                filesArr.push(lastInput[0].files[0]);
                var upImgs = "<div class='show-img-div2'><span><img src='./img/close.png' /></span><img src='" + imgSrc + "'/></div>";
                $("#labelId").before(upImgs);
                //$(".type-file-div").append(lastInput.clone()); //濡傛灉闇€瑕佸拰IE鏂瑰紡涓€鏍风殑鏂瑰紡娣诲姞澶氫釜 input 鍘讳笂浼  鎵撳紑杩欎釜娉ㄩ噴

            } else { //IE9 IE8鍏煎
                var upImgs = "<div class='show-img-div2'><span><img src='./img/close.png' /></span><img class='ie-imgshow' src='./img/null.png' /></div>";
                $("#labelId").before(upImgs);
                lastInput[0].select();
                imgSrc = lastInput[0].value;
                imgObj.push(imgSrc);
                $(".ie-imgshow").last()[0].innerHTML = "";
                $(".ie-imgshow").last()[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src='" + imgSrc + "')";
                //娣诲姞input file 缁撴瀯
                $(".type-file-div").append(lastInput.clone());

            }
            lastInput.val(''); //瑙ｅ喅鍚屽浘鐗囧垹鍚  涓嶈兘涓婁紶鐨  BUG
            if(imgObj.length>=imgNum){$("#labelId").hide()}
            //娣诲姞鏂板浘鐗囧悗闇€瑕乶ew imgPre  閲嶇疆 棰勮鍑芥暟
            obj = new imgPre(imgObj);
            gbOption = obj;
            createPreDiv();
            //鍒犻櫎鍥炬爣缁戝畾鍒犻櫎浜嬩欢
            $(".show-img-div2").each(function (k, v) {
                $(this).find('span').unbind('click');
                $(this).find('span').bind("click", function () {
                    deleteImg(imgObj, k, obj)
                })
                //鍜岄瑙堝浘鐗囨満鍒惰仈鍔 
                $(this).unbind('click');
                $(this).bind('click', function () {
                    gbOption = obj;
                    createPreDiv.imgMiddleShow(k)
                });
            })
        })
    })

}
//鐐瑰嚮鍏抽棴鍥炬爣鍒犻櫎鍥剧墖鏁扮粍
function deleteImg(imgObj, k, obj) {
    console.log(k)
    imgObj.splice(k, 1);
    filesArr.splice(k, 1);

    if(imgObj.length<imgMaxNum){
        $("#labelId").show()
    }
    //鍒犻櫎鐐瑰嚮鐨勮嚜宸 
    $(".show-img-div2:eq(" + k + ")").remove();
    //鍒犻櫎鍚庨噸鏂扮粦瀹氫簨浠 
    $(".show-img-div2").each(function (k, v) {
        $(this).find('span').unbind('click');
        $(this).find('span').bind("click", function () {
            deleteImg(imgObj, k)
        })
        //鍜岄瑙堝浘鐗囨満鍒惰仈鍔 
        $(this).unbind('click');
        $(this).bind('click', function () {
            gbOption = obj;
            createPreDiv.imgMiddleShow(k)
        });
    })

    //鐐瑰嚮鍥剧墖鍒犻櫎瀵瑰簲鐨刬nput type=file
    if (!$('.' + fileClass).first()[0].files) { 
        $('.' + fileClass).eq(k).remove(); //鍏煎IE锛岃胺姝岀瓑濡傛灉闇€瑕佸拰IE鏂瑰紡涓€鏍风殑鏂瑰紡锛屽彇娑堝垽鏂紝input灏变笉浼氬垹闄 
    }

}

//鍥剧墖杩旀樉棰勮涓撶敤锛  涓婁紶鏃朵篃浼氳仈鍔ㄧ敤鍒 
function imgPre(imgObj, flag) {
    this.imgKey = 0;
    this.imgObj = imgObj;

    var _this = this;
    //flag 鐪熻鏄庡彧鏄函棰勮鍔熻兘锛屽浘鐗囪繑鏄撅紝   涓婁紶鍔熻兘鏃朵笉缁檉lag 鍗冲彲
    if (flag) {
        //鍔ㄦ€佸湪showImgs閲屾坊鍔犲浘鐗 
        var showImgs = '';
        this.imgObj.forEach(function (v, k) {
            showImgs += "<div class='show-img-div'><img src='" + v + "'/></div>";
        })
        $('#showImgs').append(showImgs);

        //棰勮鍥剧墖缁戝畾浜嬩欢
        $('.show-img-div').each(function (k, v) {
            $(this).bind('click', function () {
                if (ispre) gbOption = ispre;
                createPreDiv.imgMiddleShow(k)
            });
        })
    }

}

//棰勮鍥剧墖鐨凞IV缁撴瀯
function createPreDiv() {
    var divStr = "<div class=\"imgs-bg\">\n <div class=\"middle\">\n <div class=\"middle-img\">\n <img src=\"\">\n</div>\n<div class=\"left\">\n<img src=\"img/left.png\">\n</div>\n<div class=\"right\">\n <img src=\"img/right.png\">\n</div>\n<p>\xD7</p>\n</div>\n </div>";
    $('body').append(divStr);
    var maxKey = gbOption.imgObj.length;
    //棰勮鍥惧乏鍙崇澶寸偣鍑讳簨浠 
    $(".imgs-bg .right").click(function () {
        if (gbOption.imgKey >= maxKey) return
        gbOption.imgKey++;
        createPreDiv.imgMiddleShow(gbOption.imgKey)
    })
    $(".imgs-bg .left").click(function () {
        if (gbOption.imgKey == 0) return
        gbOption.imgKey--;
        createPreDiv.imgMiddleShow(gbOption.imgKey)
    })
    $(".imgs-bg p").click(function () {
        $(".imgs-bg").hide();
    })
}
//棰勮鍥   瀹藉害鏍峰紡鍔ㄦ€佽皟鏁达紝涓轰簡鍝嶅簲寮 
createPreDiv.imgW = function () {
    var imgW = $(".middle-img img")[0].clientWidth;
    var imgH = $(".middle-img img")[0].clientHeight + 20;
    // console.log(imgW+'---'+documentW)
    // console.log(imgH+'---'+documentH)
    if (imgW <= documentW) {
        $('.imgs-bg .middle').css("width", imgW + 'px')
    } else {
        $('.imgs-bg .middle').css("width", documentW-80 + 'px')
    }
    if (imgH <= documentH) {
        $('.imgs-bg .middle').css("height", imgH + 'px')
    } else {
        $('.imgs-bg .middle').css("height", '100%')
    }
}
//棰勮鍥  鍔ㄦ€佹敼鍙楽RC
createPreDiv.imgMiddleShow = function (key) {
    gbOption.imgKey = key;
    $(".middle-img img").attr("src", gbOption.imgObj[key]);
    $(".imgs-bg").show();
    setTimeout(function () {
        createPreDiv.imgW();
        $(".middle-img img").css("opacity", 1)
    },30)
}


//})