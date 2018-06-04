/**
 * Created by 武海升 on 2018-05-31.
 */

$(function(){
    $('#executeJob').removeAttr('href onclick');
});

function executeJob() {
    $.ajax({
        url: 'executeJob',
        type: 'POST',
        success: function (resunlt) {
            if(resunlt.result==true){
                swal("重启任务","重启Job成功","success");
                $('#cronExpression').html(resunlt.cronExpression);
                $('#executeJob').removeAttr('href onclick');
                $('#updateJob').attr({
                    "href" : "javascript:void(0);",
                    "onclick" : "updateJob()"
                });
                $('#pauseJob').attr({
                    "href" : "javascript:void(0);",
                    "onclick" : "pauseJob()"
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
                swal("暂停任务","暂停Job成功","success");
                $('#cronExpression').html("Job已停止");
                $('#executeJob').attr({
                    "href" : "javascript:void(0);",
                    "onclick" : "executeJob()"
                });
                $('#updateJob').attr({
                    "href" : "javascript:void(0);",
                    "onclick" : "updateJob()"
                });
                $('#pauseJob').removeAttr('href onclick');
            }
        }
    });
}

function updateJob() {
    swal({
            title: "修改Job任务",
            text: "修改Job任务运行时间",
            type: "input",
            showCancelButton:true,
            closeOnConfirm:false,
            confirmButtonText:"确认",
            cancelButtonText:"取消",
            animation: "slide-from-top",
            inputPlaceholder: "输入Corn时间表达式"
        },
        function (inputValue){
            if(inputValue){
                var cronValidateResult = cronValidate(inputValue.trim());
                console.log(cronValidateResult);
                if(cronValidateResult==true){
                    $.ajax({
                        url: 'updateJob',
                        type: 'POST',
                        data : {
                            cronExpression : inputValue
                        },
                        success: function (resunlt) {
                            if(resunlt.result==true){
                                swal("修改任务","修改Job成功","success");
                                $('#cronExpression').html(resunlt.cronExpression);
                                $('#executeJob').removeAttr('href onclick');
                                $('#updateJob').attr({
                                    "href" : "javascript:void(0);",
                                    "onclick" : "updateJob()"
                                });
                                $('#pauseJob').attr({
                                    "href" : "javascript:void(0);",
                                    "onclick" : "pauseJob()"
                                });
                            }
                        }
                    });
                }else{
                    swal(cronValidateResult);
                }
            }else{
                swal("输入不能为空");
            }
        }
    );
}

function copyValue() {
    var cronValue = document.getElementById("cron");
    cronValue.select();
    document.execCommand("Copy");
}


