package pl.pabilo8.immersiveintelligence.api.data.operators.text;

import pl.pabilo8.immersiveintelligence.ImmersiveIntelligence;
import pl.pabilo8.immersiveintelligence.api.data.DataPacket;
import pl.pabilo8.immersiveintelligence.api.data.operators.DataOperator;
import pl.pabilo8.immersiveintelligence.api.data.types.DataPacketTypeAccessor;
import pl.pabilo8.immersiveintelligence.api.data.types.DataPacketTypeExpression;
import pl.pabilo8.immersiveintelligence.api.data.types.DataPacketTypeString;
import pl.pabilo8.immersiveintelligence.api.data.types.IDataType;

/**
 * Created by Pabilo8 on 05-07-2019.
 */
public class DataOperationJoin extends DataOperator
{
	public DataOperationJoin()
	{
		//A boolean version of the 'equals' operation
		name = "join";
		sign = "+";
		allowedType1 = DataPacketTypeString.class;
		allowedType2 = DataPacketTypeString.class;
		expectedResult = DataPacketTypeString.class;
	}

	@Override
	public IDataType execute(DataPacket packet, DataPacketTypeExpression data)
	{
		IDataType t1, t2;
		String i1, i2;

		t1 = data.getType1();
		if(t1 instanceof DataPacketTypeAccessor)
			t1 = packet.getPacketVariable(((DataPacketTypeAccessor)t1).variable);
		t2 = data.getType2();
		if(t2 instanceof DataPacketTypeAccessor)
			t2 = packet.getPacketVariable(((DataPacketTypeAccessor)t2).variable);

		ImmersiveIntelligence.logger.info("accessor "+t2);
		i1 = t1.valueToString();
		i2 = t2.valueToString();

		//Yes
		return new DataPacketTypeString(i1+i2);
	}
}
