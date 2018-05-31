/**
 * Created by 武海升 on 2018-05-31.
 */
function executeJob() {
    $.ajax({
        url: 'executeJob',
        type: 'POST',
        success: function (resunlt) {
            if(resunlt==true){
                swal({
                        title: "执行Job任务",
                        text: "执行Job任务成功",
                        type: "success",
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "确定!",
                        closeOnConfirm: false
                    },
                    function(){
                        window.location.href = ""
                    });
            }
        }
    });
}

function pauseJob() {
    $.ajax({
        url: 'pauseJob',
        type: 'POST',
        success: function (resunlt) {
            if(resunlt==true){
                swal({
                        title: "暂停Job任务",
                        text: "暂停Job任务成功",
                        type: "success",
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "确定!",
                        closeOnConfirm: false
                    },
                    function(){
                        window.location.href = ""
                    });
            }
        }
    });
}