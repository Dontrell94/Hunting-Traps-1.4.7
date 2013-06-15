package huntingTraps.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class FireCage extends Block
{
	int b = 1;
	
	public FireCage(int i, int j)
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
			return 0;
	    }
	    else if (side == 0)
	    {
			return 2;
	    }
	    else
	    {
			return 1;
		}
	}
	/*
	 * 0 is bottom
	 * 1 is top
	 */
	

	
	 public void onNeighborBlockChange(World world, int i, int j, int k, int l)
     {
             if(world.isBlockGettingPowered(i, j, k))
             {
                    int block = Block.fire.blockID;
	                        
                    world.setBlockWithNotify(i, j + 1, k - 1, block);
         			world.setBlockWithNotify(i, j + 1, k + 1, block);
         			world.setBlockWithNotify(i + 1, j + 1, k, block);
         			world.setBlockWithNotify(i - 1, j + 1, k, block);
         			if (this.b == 1)
        			{
         				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("! - A mob has triggered a Fire Hunting Trap nearby.");
        			}
             }
     		else
    		{
    			world.setBlockWithNotify(i, j + 1, k - 1, 0);
    			world.setBlockWithNotify(i, j + 1, k + 1, 0);
    			world.setBlockWithNotify(i + 1, j + 1, k, 0);
    			world.setBlockWithNotify(i - 1, j + 1, k, 0);
    		}
     }
}
