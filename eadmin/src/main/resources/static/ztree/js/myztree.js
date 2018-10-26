/*点击事件*/
function zTreeOnClick(event, treeId, treeNode) {
    $("*[name='id']").val(treeNode.id);
    $("*[name='name']").val(treeNode.name);
    $("*[name='href']").val(treeNode.href);
    $("*[name='level']").val(treeNode.level);
    $("*[name='tId']").val(treeNode.tId);
    var opts = $("*[name='status']").find('option');
    $.each(opts, function(){
        if(treeNode.status == $(this).val()){
            $(this).attr('selected', "");
        } else {
            $(this).removeAttr("selected");
        }
    });
    layui.form().render("select");
    if(treeNode.getParentNode() != null) {
        var parentNode = treeNode.getParentNode();
        $("*[name='parentName']").val(parentNode.name);
        $("*[name='parentId']").val(parentNode.id);
    } else {
        $("*[name='parentName']").val('');
        $("*[name='parentId']").val(0);
    }


};