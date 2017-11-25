create table m_user
(
	id					int						identity(1,1)				not null,	
	username			nvarchar(50)										not null,	
	password			nvarchar(50)										not null,	
	email				nvarchar(50)										not null,
	nickName			nvarchar(50)										not null,	
	regTime				datetime											not null
)