<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题管理</title>
<link rel="stylesheet" type="text/css"
	href="../../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../themes/icon.css">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {

		$('#dg').datagrid({
			rownumbers : true,
			width : 1100,
			height : 400,
			url : 't_test.action',
			columns : [ [ {
				field : '复选框',
				title : '复选框',
				width : 50,
				checkbox : true
			}, {
				field : 'id',
				title : '库序号',
				width : 50,
				align : 'left'
			}, {
				field : 'test_uuid',
				title : '试题号',
				width : 50,
				align : 'left'
			}, {

				field : 'test_question',
				title : '题目',
				width : 280
			}, {
				field : 'test_select_a',
				title : '选项A',
				width : 100,
				align : 'center'
			}, {
				field : 'test_select_b',
				title : '选项B',
				width : 100,
				align : 'center'
			}, {
				field : 'test_select_c',
				title : '选项C',
				width : 100,
				align : 'center'
			}, {
				field : 'test_select_d',
				title : '选项D',
				width : 100,
				align : 'center'
			}, {
				field : 'test_answer',
				title : '答案',
				width : 40,
				align : 'center'
			}, {
				field : 'test_explain',
				title : '题目解释',
				width : 200,
				align : 'left'
			}

			] ],

			//点击行时复选框选中问题
			onClickRow : function(index, data) {
				var selectIndex = -1;
				if (index == selectIndex) {
					//第一次单击选中,第二次单击取消选中
					$(this).datagrid('unselectRow', index);

					selectIndex = -1;
				} else {
					selectIndex = index;
				}

			},

			// 显示分页工具条
			pagination : true,
			/* 	 fitColumns:true, */

			// 初始化的页数
			pageNumber : 1,
			// 每页显示记录数:
			pageSize : 10,
			// 分页工具条中下拉列表中的值：
			pageList : [ 1, 5, 10, 15 ],

			// 隔行换色
			striped : true,
			/* toolbar : '#pp'  */
			toolbar : [

			{
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$('#winAdd').window('open');

				}
			}, {
				//<input class="textbox" style="WIDTH: 300px; height: 23px" type="text" id="searchinput" placeholder="请输入关键字"></input>
				text : '搜索',
				iconCls : 'icon-search',
				handler : function() {
					$('#winSearch').window('open');

				}
			},

			{
				text : '编辑行',
				iconCls : 'icon-edit',
				handler : function() {

					var id = getSelections();
					if (id.length < 1) {

						return alert("请选择一条需要修改的数据");

					}
					if (id.length > 1) {
						alert("您已选择多条数据，请选择一条需要修改的数据");
						$("#dg").datagrid("reload");
						return null;
					}

					var flag = confirm("确认编辑序号为" + id + "数据");

					if (flag) {
						edit(id);

					} else {
						$("#dg").datagrid("reload");
						return null;
					}

				}
			}, {
				text : '帮助',
				iconCls : 'icon-help',
				handler : function() {
					alert('help')
				}
			}, {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {

					var ids = getSelections();

					if (ids == null || ids == "") {
						return alert("请选择要删除的数据行");

					}

					var flag = confirm("确认删除序号=" + ids + "的试题");
					if (!flag) {
						$("#dg").datagrid("reload");
						return null;
					}else {
						del(ids);	
					}
				}
			}, {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					alert('保存')
				}
			} ]

		});

		$(document).ready(function() {

		});

		$("#tactiveselect").bind("change", function() {
			//设置input输入框可用（初始化是不可用）
			//$("#upactid").attr("disabled",false); 
			//bianhao是<option>标签中自定义的属性，是为了获取后台传过来的值
			//var bianhao = $(this).find("option:selected").value; 
			var bianhao = $(this).children('option:selected').val();
			//向input输入框中赋值
			$("#tupactid").val(bianhao);
		});
		$("#tactiveselect2").bind("change", function() {
			//设置input输入框可用（初始化是不可用）
			//$("#upactid").attr("disabled",false); 
			//bianhao是<option>标签中自定义的属性，是为了获取后台传过来的值
			//var bianhao = $(this).find("option:selected").value; 
			var bianhao = $(this).children('option:selected').val();
			//向input输入框中赋值
			$("#tupactid2").val(bianhao);
		});
		
		
		/* $(window).resize(function() {
			fitCoulms();
		});
		 */

		$('#winUpdate').window({
			onBeforeClose : function() {
				$("#dg").datagrid("reload");
			}
		});

		//关闭添加框，reload
		$('#winAdd').window({
			onBeforeClose : function() {
				$("#dg").datagrid("reload");
			}
		});

		$('#winSearch').window({
			onBeforeClose : function() {
				$("#dg").datagrid("reload");
			}
		});
		/* 	function fitCoulms() {
				$('#dg').datagrid({
					fitColumns : true
				});
			} */

		$('#addbtn').bind('click', function() {

			save();

		});

	});

	function getSelected() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {

			id = row.id;
			return id;

		}
	}
	function getSelections() {
		var ids = [];
		var rows = $('#dg').datagrid('getSelections');
		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].id);
		}
		/* alert(ids.join('\n'));  */
		return ids;

	}

	function save() {

		var getr = confirm("确认提交")
		if (getr == true) {

			// 提交数据到Action
			$('#formAdd').form('submit', {
				url : "t_save.action",
				success : function(data) {
					// data是字符串类型
					// "alert('')"
					var jsonData = eval("(" + data + ")");
					$.messager.show({
						title : '提示消息',
						msg : jsonData.msg,
						timeout : 4000,
						showType : 'slide',
						style:{
							right:'',
							top:document.body.scrollTop+document.documentElement.scrollTop,
							bottom:''
						}
					});

					// 关闭窗口
					$("#winAdd").window("close");
					// 表格重新加载
					$("#dg").datagrid("reload");
				}
			});

		}

	}

	//清空输入框
	function clearvalue() {
		$(":input", ".easyui-window").not(":button", ":reset", "hidden",
				"submit").val("").removeAttr("checked").removeAttr("selected");

	}

	//删除
	function del(ids) {
		//alert("删除语句ids=" + ids);
		//var getr = confirm("确认删除试题"+ids);
		$.post("t_delete.action?ids=" + ids, function(data) {
			$.messager.show({
				title : '提示消息',
				msg : data.msg,
				timeout : 4000,
				showType : 'slide',
				style:{
					right:'',
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			});
			$("#dg").datagrid("reload");
		}, "json");
	}

	//更新
	function edit(id) {
		// alert(id);

		$("#winUpdate").window("open");

		$('#formUpdate').form('load', "t_edit.action?id=" + id);

	}
	function update() {
		$('#formUpdate').form({
			url : "t_update.action",
			success : function(data) {
				var jsonData = eval("(" + data + ")");
				$.messager.show({
					title : '提示消息',
					msg : jsonData.msg,
					timeout : 4000,
					showType : 'slide',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});
				// 关闭窗口:
				$("#winUpdate").window("close");
				// 重新加载数据:
				$("#dg").datagrid("reload");
			}
		});
		// submit the form    
		$('#formUpdate').submit();

	}
</script>
</head>
<body>




	<table id="dg">

	</table>
	<!-- 搜索教师的表单，默认是隐藏的 -->
	<div id="winSearch" class="easyui-window" title="查询"
		style="width: 400px; height: 150px"
		data-options="iconCls:'icon-search',modal:true,closed:true">

		<h4>请选择查询方式，再输入查询名称</h4>


		<input id="ss" class="easyui-searchbox" style="width: 300px"
			data-options="prompt:'Please Input Value',menu:'#mm'"></input>
		<div id="mm" style="width: 120px">
			<div data-options="name:'teacher_name',iconCls:'icon-ok'">姓名</div>
			<div data-options="name:'teacher_id'">教工号</div>
			<div data-options="name:'teacher_idcard'">身份证号</div>
		</div>

	</div>




	<!-- 添加教师的表单，默认是隐藏的 -->
	<div id="winAdd" class="easyui-window" title="录入题目"
		style="width: 900px; height: 520px"
		data-options="iconCls:'icon-save',modal:true,closed:true">

		<form id="formAdd" method="post">
			<TABLE cellSpacing=0 cellPadding=5 border=0>
				
				<TR>

					<td>题目：</td>
					<td colspan="3">
						
						<textarea  rows="3" cols="85" name="test_question"></textarea>
						</td>
						
				</TR>

				<TR>

				<td>选项A：</td>
					<td><!-- <INPUT class=textbox style="WIDTH: 350px; height: 80px"
						maxLength=50 name="test_select_a"> -->
							<textarea  rows="3" cols="30" name="test_select_a"></textarea>
						</td>
				
				<td>选项B：</td>
					<td><!-- <INPUT class=textbox style="WIDTH: 350px; height: 80px"
						maxLength=50 name="test_select_b"> -->
							<textarea  rows="3" cols="30" name="test_select_b"></textarea>
						</td>
						
				</TR>

				<TR>

				<td>选项C：</td>
					<td><!-- <INPUT class=textbox style="WIDTH: 350px; height: 80px"
						maxLength=50 name="test_select_c"> -->
							<textarea  rows="3" cols="30" name="test_select_c"></textarea>
						</td>
				
				<td>选项D：</td>
					<td><!-- <INPUT class=textbox style="WIDTH: 350px; height: 80px"
						maxLength=50 name="test_select_d"> -->
							<textarea  rows="3" cols="30" name="test_select_d"></textarea>
						</td>
						
				</TR>
				<TR>

					<td>答案：</td>
					<td ><INPUT class=textbox style="WIDTH: 130px; height: 40px"
						maxLength=50 name="test_answer" id="tupactid"><select
						style="WIDTH: 220px; height: 40px" id="tactiveselect"
						class=textbox>
							<option value="未选择" selected="selected">---选择---</option>
							<option value="A">----A----</option>
							<option value="B">----B----</option>
							<option value="C">----C----</option>
							<option value="D">----D----</option>
					</select></td>
					<td colspan="3">提示：（输入或选择A、B、C、D）</td>
				</TR>
               <TR>

					<td>题目解释：</td>
					<td colspan="3"><!-- <INPUT class=textbox style="WIDTH: 800px; height: 90px"
						maxLength=50 name="test_explain"> -->
							
							<textarea  rows="3" cols="85" name="test_explain"></textarea>
						</td>
				</TR>



				<tr>
				<td>&nbsp;&nbsp;</td>
					<td rowspan=2 colspan="3"><a class="easyui-linkbutton"
						data-options="iconCls:'icon-cut'" onclick="clearvalue()">清除内容</a>
&nbsp;&nbsp;
					<a id="addbtn" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-save'">确认提交</a>

					</td>
				</tr>
			</TABLE>
		</form>
	</div>

	<!-- 编辑更新权限的表单，默认是隐藏的 -->
	<div id="winUpdate" class="easyui-window" title="修改客户"
		style="900px; height: 520px"
		data-options="iconCls:'icon-save',modal:true,closed:true">

		<form id="formUpdate" method="post">

			<TABLE cellSpacing=0 cellPadding=5 border=0>
				<TR>

					<td>库序号：</td>
					<td>
					<INPUT type="hidden" style="WIDTH: 180px; height: 25px"
						maxLength=50 name="id">
					<INPUT class=textbox style="WIDTH: 180px; height: 25px"
						maxLength=50 name="id" disabled="disabled"></td>
				</TR>
				<TR>
<INPUT type="hidden" style="WIDTH: 180px; height: 25px"
						maxLength=50 name="test_uuid" >
					<td>试题号：</td>
					<td><INPUT class=textbox style="WIDTH: 180px; height: 25px"
						maxLength=50 name="test_uuid" disabled="disabled"></td>
				</TR>
				<TR>

					<td>题目：</td>
					<td colspan="3">
						
						<textarea  rows="3" cols="85" name="test_question"></textarea>
						</td>
						
				</TR>

				<TR>

				<td>选项A：</td>
					<td><!-- <INPUT class=textbox style="WIDTH: 350px; height: 80px"
						maxLength=50 name="test_select_a"> -->
							<textarea  rows="3" cols="30" name="test_select_a"></textarea>
						</td>
				
				<td>选项B：</td>
					<td><!-- <INPUT class=textbox style="WIDTH: 350px; height: 80px"
						maxLength=50 name="test_select_b"> -->
							<textarea  rows="3" cols="30" name="test_select_b"></textarea>
						</td>
						
				</TR>

				<TR>

				<td>选项C：</td>
					<td><!-- <INPUT class=textbox style="WIDTH: 350px; height: 80px"
						maxLength=50 name="test_select_c"> -->
							<textarea  rows="3" cols="30" name="test_select_c"></textarea>
						</td>
				
				<td>选项D：</td>
					<td><!-- <INPUT class=textbox style="WIDTH: 350px; height: 80px"
						maxLength=50 name="test_select_d"> -->
							<textarea  rows="3" cols="30" name="test_select_d"></textarea>
						</td>
						
				</TR>
				<TR>

					<td>答案：</td>
					<td ><INPUT class=textbox style="WIDTH: 130px; height: 40px"
						maxLength=50 name="test_answer" id="tupactid2"><select
						style="WIDTH: 220px; height: 40px" id="tactiveselect2"
						class=textbox>
							<option value="未选择" selected="selected">---选择---</option>
							<option value="A">----A----</option>
							<option value="B">----B----</option>
							<option value="C">----C----</option>
							<option value="D">----D----</option>
					</select></td>
					<td colspan="3">提示：（输入或选择A、B、C、D）</td>
				</TR>
               <TR>

					<td>题目解释：</td>
					<td colspan="3"><!-- <INPUT class=textbox style="WIDTH: 800px; height: 90px"
						maxLength=50 name="test_explain"> -->
							
							<textarea  rows="3" cols="85" name="test_explain"></textarea>
						</td>
				</TR>
				<tr>
					<td>&nbsp;&nbsp;</td>
					<td rowspan=2><a class="easyui-linkbutton"
						data-options="iconCls:'icon-cut'" onclick="clearvalue()">清除数据</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
					<a id="updatebtn" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-save'"
						onclick="update()">确认修改</a></td>
				</tr>



			</TABLE>
		</form>
	</div>


</body>
</html>