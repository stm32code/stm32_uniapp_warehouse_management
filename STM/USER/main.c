#include "delay.h"
#include "key.h"
#include "sys.h"
#include "usart.h"
#include "uart2.h"
#include "uart3.h"
#include "ds18b20.h"
#include "wifi.h"
#include "gpio.h"
#include "stdio.h"
#include "glr_adc.h"
#include "rc522.h"
#include "bsp_dht11.h"
extern __IO u16 data_value[6];
u32		AD1_value, hy, trq, AD5_value;
/* �¶ȱ���ֵ */
double			temperatureLimit;
int			flameLimit;
int			gasLimit;
int			smokeLimit;
u8			ds18b20_state;
int			i;
DHT11_Data_TypeDef	dht11_data;
int			dht11_flag;


/**
 *   ����˵����
 *   1--SDA  <----->PA4
 *   2--SCK  <----->PA5
 *   3--MOSI <----->PA7
 *   4--MISO <----->PA6
 *   5--����
 *   6--GND <----->GND
 *   7--RST <----->PB0
 *   8--VCC <----->VCC
 **/


void init( void )
{
	DELAY_INIT();                                           /* ��ʼ��ʱ�� �ӳٺ���ʹ�� */
	NVIC_PriorityGroupConfig( NVIC_PriorityGroup_2 );       /* ����NVIC�жϷ��� */
	 
	ESP_INIT();



	printf( "wifi��ʼ���ɹ�" );
	RC522_Init();
	DHT11_GPIO_Config();
}


int main( void )
{
	float	wd	= 0;
	float	sd	= 0;
	float	yw	= 0;
	int	num	= 0;

	u8 p[100] = "";
/*	char	cRes[512]	= ""; */
	init();
	printf( "ϵͳ��ʼ���ɹ�\n" );
	GPIO_SetBits( GPIOB, GPIO_Pin_15 );
	delay_ms( 500 );
	GPIO_ResetBits( GPIOB, GPIO_Pin_15 );
	while ( 1 )
	{
		RC522_Handel();
	 
	}
}


