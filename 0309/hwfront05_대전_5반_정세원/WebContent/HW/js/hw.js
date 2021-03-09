
$(function(){

	$('.login').click(function(){
		$('#myModal').show();
	});
	
	$('.close,.close-btn').click(function(){
		$('#myModal').hide();
	});
	
	$('.login-btn').click(function(){
		let input_id=$('#login_id').val();
		let input_pwd=$('#login_pwd').val();
		$.ajax({
			url: 'userlist.xml',
			type:'GET',
			dataType:'xml',
			success:function(data){
				modal_login(data);
			},
			error: function(){ // 로딩 에러시
				alert('Error loading XML document'); 
				}
		});
		
		function modal_login(data){
			$(data).find('user').each(function(){
				let tmp_id = $(this).find('id').text();
				let tmp_pwd =$(this).find('password').text();
				
				if(input_id==tmp_id){
					if(input_pwd==tmp_pwd){
						//로그인 성공->로그인 성공 화면으로 넘어가기
						$('.before_login').css('display','none');
						$('.after_login').css('display','');
						$('.success-id').append(input_id);
						$('#myModal').hide();
					}else{
						alert('비밀번호가 틀립니다.');
					}
				}
			})
		}
	});
	$('.logout').click(function(){
		$.ajax({
			success:function(){
				$('.after_login').css('display','none');
				$('.before_login').css('display','');
			}
		})
	})
	
	$('.join').click(function(){
		
		$('.join-page').css('display','');
		
	})
	
	$('.join-btn').click(function(){
		let new_id=$('#id').val();
		$.ajax({
			url: 'userlist.xml',
			type:'GET',
			dataType:'xml',
			success:function(data){
				join_confirm(data);
			},
			error: function(){ // 로딩 에러시
				alert('Error loading XML document'); 
				}
		});
		
		
		function join_confirm(data){
			var check = false;
			$(data).find('user').each(function(){
				let tmp_id = $(this).find('id').text();			
				if(new_id==tmp_id){
					check = true;
					alert('중복된 ID입니다. 다시 입력해주세요.');
				}
			})
			if(check==false){
				alert('회원가입이 완료되었습니다.');
				$('.join-page').css('display','none');
			}
		}
	})
});
