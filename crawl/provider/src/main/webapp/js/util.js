/**
 * @file util.js 工具代码
 * @author hushun01(hushun01@baidu.com)
 * @param {string} clock 元素ID
 */
function realSysTime(clock) {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var date = now.getDate();
    var day = now.getDay();
    var hour = now.getHours();
    var minu = now.getMinutes();
    if (minu < 10) {
        minu = '0' + minu;
    }

    var sec = now.getSeconds();
    if (sec < 10) {
        sec = '0' + sec;
    }
    var weekArr = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    var week = weekArr[day];
    var time = year + '年' + month + '月' + date + '日 ' + week + ' ' + hour
        + ':' + minu + ':' + sec;
	// 组合系统时间
    clock.innerHTML = time;
}