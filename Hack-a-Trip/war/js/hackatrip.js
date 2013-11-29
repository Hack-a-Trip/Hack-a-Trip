function view_location(id)
{
        width = 1000;
        height = 500;
        if(window.innerWidth)
        {
                var left = (window.innerWidth-width)/2;
                var top = (window.innerHeight-height)/2;
        }
        else
        {
                var left = (document.body.clientWidth-width)/2;
                var top = (document.body.clientHeight-height)/2;
        }
        window.open('https://outpost.travel/#!/item/houserental/airbnb/' + id + '?sdate=&edate=&guests=1','nom_de_ma_popup','menubar=no, scrollbars=no, top='+top+', left='+left+', width='+width+', height='+height+'');
}

function book(url)
{
        width = 1000;
        height = 500;
        if(window.innerWidth)
        {
                var left = (window.innerWidth-width)/2;
                var top = (window.innerHeight-height)/2;
        }
        else
        {
                var left = (document.body.clientWidth-width)/2;
                var top = (document.body.clientHeight-height)/2;
        }
        window.open(url,'nom_de_ma_popup','menubar=no, scrollbars=no, top='+top+', left='+left+', width='+width+', height='+height+'');
}