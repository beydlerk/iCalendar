# iCalendar
Team Dois: A Calendar project for ICS 314.

By Week 7:

your	team has	registered	your project	on	github
• everyone	in	the	group	has	used	a calendaring	system	of	their	choice	to	create	
a	.ics	event	file	and	has	looked	at	the	content	of	that	file	with	a	text	editor	
such	(such	as	vim or	textedit).	“Reverse	engineering”	.ics	files	can	offer	
significant	insight.		
• your	team	has	functioning	code,	no	matter	how	minimal:	You	must	
demonstrate	code that	generates	a	.ics	file	for	a	simple,	single	occurrence
event	such	as:		Study	for	exam,	1pm-2pm	HST,	12	May	2016,	in	Hamilton	
Library.		You	must	then	demonstrate	that	the	calendar	program	of	your	
choice	(say,	google	calendar)	successfully	reads	and	processes	the	.ics	files	
you	generate.			The	code	could	be	a	simple	as	print	statements,	but		for	that	
single	event,	but	it	must	generate	an	.ics	file	that	is	readable	by	a	calendar	
project.
• In	the	real-world,	your	code	would	be	embedded	in	a	larger	calendaring	
system,	so	don’t	worry	much	about	a	user	interface.		In	fact,	to	create		.ics	
files	your	user	interface	can	be	command	line	or	simple	drop-down	menus.

By Week 9:

system	allows	the		use	of	the	“geographic	position”	field	described	in	section	
3.8.1.6	of	the	RFC.		Events	are	not	required	to	use	the	field,	but	if	the	
information	is	provided	by	the	user,	your	system	must	support	it	by	putting	
it	into	the	event	file.
• your	systems	must	also	implement		the	“classification”	field	as	described	in	
section	3.8.1.3	of	the	RFC.		Events	are	not	required	to	use	the	field,	but	if	the	
information	is	provided	by	the	user,	your	system	must	support	it	by	putting	
it	into	the	event	file
• Your	team	has	a	systematic	way	of	testing	the	code as	you	are	writing	it.		I
suggest,	among	other	things,	using	JUnit	to	develop	and	execute	test	cases	as	
you	are	developing	code	(http://www.junit.org/node/49)	

By Week 11:

Your	system	can	read-in	an	arbitrary	number	of	event	files	for	a	single	date,	
sort	of	the	events	by		start	time,	then	compute	the	great	circle	distance	
(https://en.wikipedia.org/wiki/Great-circle_distance),	based on	the		
geographic	position	of	successive	events.		You	shall	record	the	great	circle	
distance	in	the	comment	field	of	the	first-occurring	event	(see	section	3.8.1.4	
about	comments).		Here’s	an	example:
EventN	occurs	from	11am-1pm
EventNplusOne	occurs	from	130pm-3pm
EventNplusTwo	occurs	from	4pm-5pm
Your	system	will	compute	the	great	circle	distance,	in	statue	miles	and	kilometers,	
from	the	location	of	EventN	to	EventNplusOne,	and	record	that	in	the	comment	field	
of	EventN.		
Similarly,	your	system	will	compute	the	great	circle	distance,	in	statue	miles	and	
kilometers,	from	the	location	of	EventNplusOne	to	EventNplusTwo,	and	record	that	
in	the	comment	field	of	EventNplusOne.
The	idea	is	to	give	the	user	an	idea	how	far	apart	their	events	are	(can	they	walk?		
Bus?		Drive?	Fly?)
But	I	said	that	location	was	optional	for	events.		What	if	there	is	only	one	event?		
What	do	you	do	with	the	last	event	of	the	day?	What	are	you	going	to	do	then?		
You’ll	have	to	think	about	it	and	come	up	with	something	reasonable.


Final Deliverable:

The	URL	for	a	5	minute	narrated video	demonstration	of	your	final	project.		
One	demo	per	team. Your	demo	shall	not	be	longer	than	five	minutes.		You	can	
use	jing.com,	screencast-o-matic.com,	….,	or	if	you	are	using	a	Mac,	
QuickTime,	to	capture	your	screen	to	video.	You	need	to	demonstrate	the	
functionality	described	below.
• A	one-page	pdf	document	convincing	me	that	your	system	is	correct.	That	is,	
how	did	you	test	your	system	and what	were	the	results?
• A	link	to	your	documented	source	code on	github. We	will	check	that	commit	
history	to	make	sure	everyone	on	the	team	is	participating.


