package gaia.renderer.entity.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerAlpha implements LayerRenderer<EntityLiving> {
	private ResourceLocation alphaTexture;
	private RenderLiving<EntityLiving> livingEntityRenderer;

	public LayerAlpha(RenderLiving<EntityLiving> livingEntityRendererIn, ResourceLocation textureIn) {
		livingEntityRenderer = livingEntityRendererIn;
		alphaTexture = textureIn;
	}

	@Override
	public void doRenderLayer(EntityLiving entity, float f1, float f2, float partialTicks, float f4, float f5, float f6, float scale) {
		livingEntityRenderer.bindTexture(alphaTexture);

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableNormalize();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(770, 771);

		livingEntityRenderer.getMainModel()
				.render(entity, f1, f2, f4, f5, f6, scale);
		livingEntityRenderer.setLightmap(entity);

		GlStateManager.disableBlend();
		GlStateManager.disableNormalize();
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
