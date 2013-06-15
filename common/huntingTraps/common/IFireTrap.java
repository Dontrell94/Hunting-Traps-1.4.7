package huntingTraps.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class IFireTrap extends Block
{
	int b = 1;
	
	public IFireTrap(int i, int j)
	{
		super(i, Material.rock);
	}
	
	public String getTextureFile()
    {
            return "/huntingTraps/textures/hnttrp.png";
    }
	
	@Override
	public int getBlockTextureFromSide(int side)
	{
	    if (side == 1)
	    {
			return 6;
	    }
	    else if (side == 0)
	    {
			return 8;
	    }
	    else
	    {
			return 7;
		}
	}
	/*
	 * 0 is bottom
	 * 1 is top
	 */
	
	 public void onNeighborBlockChange(World world, int i, int j, int k, int l)
     {
             if(world.isBlockIndirectlyGettingPowered(i, j, k))
             {
            	int block = Block.fire.blockID;
            	
     			world.setBlockWithNotify(i, j + 1, k, block);
     		 }
             else
     		{
     			world.setBlockWithNotify(i, j + 1, k, 0);
     		}
     }
}
