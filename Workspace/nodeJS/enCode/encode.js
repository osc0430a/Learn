const f = ['ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ',
'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ',
'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'];
const s = ['ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ',
'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ',
'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'];
const t = ['', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ',
'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ',
'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ',
'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'];

const cf = ['G', 'Gg', 'N', 'D', 'Dd', 'R', 'M',
'B', 'Bb', 'S', 'Ss', 'O', 'J', 'Jj',
 'Ch', 'C', 'T', 'P', 'H']
const cs = ['1', 'A', '2', 'B', '3', 'C', '4',
 'D', '5', 'E', 'F', 'G', '6', '7',
 'H', 'I', 'J', '8', '9', 'K', '0']


var getConstantVowel = function (kor) {
    // console.log("Start: "+kor);

    const ga = 44032;

    let uni = kor.charCodeAt(0);

    uni = uni - ga;

    let fn = parseInt(uni / 588);
    let sn = parseInt((uni - (fn * 588)) / 28);
    let tn = parseInt(uni % 28);

    // console.log("End: "+kor);
    return {
        f: f[fn],
        s: s[sn],
        t: t[tn]
    };
}


var f_match = (tf) => {

    for(var i=0; i<f.length; i++){

      if(f[i] == tf){

        tf = cf[i];
        break;

      }

    }

    return tf;

}


var s_match = (ts) => {

  for(var i=0; i<s.length; i++){

    if(s[i] == ts){

      ts = cs[i];
      break;

    }

  }

  return ts;

}


var encoding = (temp) => {

    var result = {"f":"", "s":"", "t":""};

    for (var i = 0; i < temp.length; i++) {

        var tf = temp[i]["f"];
        var ts = temp[i]["s"];
        if(temp[i]["t"] == "")
          var tt = ".";
        else
          var tt = temp[i]["t"];

        tf = f_match(tf);
        ts = s_match(ts);

        result["f"] = result["f"]+tf;
        result["s"] = result["s"]+ts;
        result["t"] = result["t"]+tt;

    }
    
    return result["f"]+result["t"]+result["s"];

}


const readline = require("readline");

const rl = readline.createInterface(
    {input: process.stdin, output: process.stdout}
);

rl.on("line", function (toDo) {
        // console.log("toDo: ", toDo);
        // var result;
        toDo = toDo.split("");
        // toDo = getConstantVowel(toDo[0]);
        // console.log(toDo);
        // // console.log("toDo: ", toDo[0]);
        var temp = [];

        if (toDo.length <= 3) {

            for (var i = 0; i < toDo.length; i++) {

                temp[i] = getConstantVowel(toDo[i]);               

            }            

        }
        else{

          for (var i = 0; i < 3; i++) {

                temp[i] = getConstantVowel(toDo[i]);

            }

        }
        // console.log(temp);
        // console.log(temp.length);
        
        code = encoding(temp);
        console.log(code);

        rl.close();

    }).on("close", function () {
        process.exit();

})