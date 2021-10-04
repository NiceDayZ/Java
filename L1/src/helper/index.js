const request = require('request');


function getRandomInt(max) {
    return Math.floor(Math.random() * max) + 1;
  }

function getRandomKey(length) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
      result += characters.charAt(Math.floor(Math.random() * 
 charactersLength));
   }
   return result;
}

function requestHttp(value, key, sync, mock, times, random=false){
    for(i=0; i<times; i++){
        request({
            uri: `http://localhost:8080/back?value=${value}&key=${key}&sync=${sync}&mock=${mock}`,
        });
    }

}

console.time("dbsave");
if(process.argv[2] == 'call'){
    argv = process.argv;
    if(argv[3] && argv[4] && argv[5] && argv[6]){
        requestHttp(argv[3], argv[4], argv[5], argv[6], 1)
    }else{
        console.log("Expected 4 arguments for method 'call' (value, key, sync, mock)")
    }
}else if(process.argv[2] == 'random'){
    sync = getRandomInt(2) == 1;
    mock = getRandomInt(2) == 1;
    requestHttp(getRandomInt(10), getRandomKey(6), sync, mock, 1);
}else if(process.argv[2] == 'stress'){
    argv = process.argv;
    if(argv[3] && argv[4]){
        requestHttp(getRandomInt(10), getRandomKey(6), argv[4], true, argv[3]); 
    }else{
        console.log("Expected 2 arguments for method 'stress' (call_nr, sync)")
    }
}else{
    console.log('First argument should be call, random, or stress')
}
console.timeEnd("dbsave");