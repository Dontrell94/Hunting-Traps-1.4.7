package huntingTraps.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class CageTrap extends Block
{
	int b = 1;
	int textureTop;
	int textureSide;
	
	public CageTrap(int i, int j)
	{
		super(i, Material.ground);
		
		textureSide = 2;
		textureTop = 1;
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
	        return 5;
	    }
	    else if (side == 0)
	    {
	        return 6;
	    }
	    else
	    {
	        return 4;
	    }
	}
	
	public void onNeighborBlockChange(World world, int i, int j, int k, int l)
     {
             if(world.isBlockGettingPowered(i, j, k))
             {
                     int block = Block.fenceIron.blockID;
	                        
	                world.setBlockWithNotify(i, j + 1, k - 1, block);
	    			world.setBlockWithNotify(i, j + 2, k - 1, block);
	    			world.setBlockWithNotify(i, j + 1, k + 1, block);
	    			world.setBlockWithNotify(i, j + 2, k + 1, block);
	    			world.setBlockWithNotify(i + 1, j + 1, k, block);
	    			world.setBlockWithNotify(i + 1, j + 2, k, block);
	    			world.setBlockWithNotify(i - 1, j + 1, k, block);
	    			world.setBlockWithNotify(i - 1, j + 2, k, block);
	    			world.setBlockWithNotify(i, j, k, block);
	    			
	    			world.setBlockWithNotify(i + 1, j + 1, k - 1, block);
	    			world.setBlockWithNotify(i + 1, j + 2, k - 1, block);
	    			
	    			world.setBlockWithNotify(i - 1, j + 1, k - 1, block);
	    			world.setBlockWithNotify(i - 1, j + 2, k - 1, block);
	    			
	    			world.setBlockWithNotify(i - 1, j + 1, k + 1, block);
	    			world.setBlockWithNotify(i - 1, j + 2, k + 1, block);
	    			
	    			world.setBlockWithNotify(i + 1, j + 1, k + 1, block);
	    			world.setBlockWithNotify(i + 1, j + 2, k + 1, block);
	    			
	    			if (this.b == 1)
	    			{
	    				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("! - A mob has triggered a Cage Trap nearby.");
	    			}
             	}
     		else
    		{
     		   world.setBlockWithNotify(i, j + 1, k - 1, 0);
               world.setBlockWithNotify(i, j + 2, k - 1, 0);
               world.setBlockWithNotify(i, j + 1, k + 1, 0);
               world.setBlockWithNotify(i, j + 2, k + 1, 0);
               world.setBlockWithNotify(i + 1, j + 1, k, 0);
               world.setBlockWithNotify(i + 1, j + 2, k, 0);
               world.setBlockWithNotify(i - 1, j + 1, k, 0);
               world.setBlockWithNotify(i - 1, j + 2, k, 0);
               world.setBlockWithNotify(i + 1, j + 1, k - 1, 0);
               world.setBlockWithNotify(i + 1, j + 2, k - 1, 0);
               world.setBlockWithNotify(i - 1, j + 1, k - 1, 0);
               world.setBlockWithNotify(i - 1, j + 2, k - 1, 0);
               world.setBlockWithNotify(i - 1, j + 1, k + 1, 0);
               world.setBlockWithNotify(i - 1, j + 2, k + 1, 0);
               world.setBlockWithNotify(i + 1, j + 1, k + 1, 0);
               world.setBlockWithNotify(i + 1, j + 2, k + 1, 0);
    		}
            
     }
}